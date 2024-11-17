import IsleHeights from "@/assets/icons/IsleHeights.tsx";
import {cn, Env} from "@/utils/utils.ts";
import {GameStage, Ground, Island, Map, Terrain, TerrainType} from "@/types/GameTypes.ts";
import Topology from "@/assets/icons/Topology.tsx";
import DialogSuccess from "@/components/game/DialogSuccess.tsx";
import DialogFailure from "@/components/game/DialogFailure.tsx";
import {useEffect, useState} from "react";
import {Level} from "@/types/LevelTypes.ts";
import axios from "axios";
import {buildMap} from "@/game/Game.ts";
import Color from "color";
import {useNavigate, useParams} from "react-router-dom";

const WATER_COLOR    = Color("#2E8AE6");
const LIGHT_COLOR    = Color("#26b126");
const DARK_COLOR     = Color("#042908");
const DISABLED_COLOR = Color("#576068");

type GameParams = {
  level: string
}

const Game = () => {
  const gameParams = useParams<GameParams>();
  const navigate = useNavigate();

  const [loading, setLoading]             = useState(true);
  const [level, setLevel]                 = useState<Level>();
  const [map, setMap]                     = useState<Map>();
  const [hoverIsland, setHoverIsland]     = useState<Island>();
  const [highestIsland, setHighestIsland] = useState<Island>();
  const [tries, setTries]                 = useState<number>(3);
  const [gameStage, setGameStage]         = useState<GameStage>(GameStage.InProgress);

  useEffect(() => {
    axios.get(`${Env.API_URL}/levels/${gameParams.level}`)
      .then(response => {
        setLevel(response.data);
        setMap(buildMap(response.data));
        setLoading(false);
      });
  }, [gameParams]);
  
  useEffect(() => {
    setHighestIsland(map && map.island.reduce((island1, island2) => (island1.average > island2.average ? island1 : island2), map.island[0]));
  }, [map]);

  useEffect(() => {
    if (navigate && gameStage === GameStage.End)
      navigate("/");
  }, [gameStage, navigate]);
  
  if (loading || !level || !map)
    return <></>;

  const isGroundAndWaterUp = (terrain: Terrain) =>
    terrain.row == 0 || terrain.type === TerrainType.Ground && map.terrain[terrain.row - 1][terrain.column].type === TerrainType.Water;

  const isGroundAndWaterBottom = (terrain: Terrain) =>
    terrain.row == 29 || terrain.type === TerrainType.Ground && map.terrain[terrain.row + 1][terrain.column].type === TerrainType.Water;

  const isGroundAndWaterLeft = (terrain: Terrain) =>
    terrain.column == 0 || terrain.type === TerrainType.Ground && map.terrain[terrain.row][terrain.column - 1].type === TerrainType.Water;

  const isGroundAndWaterRight = (terrain: Terrain) =>
    terrain.column == 29 || terrain.type === TerrainType.Ground && map.terrain[terrain.row][terrain.column + 1].type === TerrainType.Water;

  const isIslandHovered = (terrain: Terrain) =>
    terrain.type === TerrainType.Ground && !isIslandDisabled(terrain) && (terrain as Ground).island === hoverIsland;

  const isIslandDisabled = (terrain: Terrain) =>
    terrain.type === TerrainType.Ground && (terrain as Ground).island.selected;

  const calculateBackground = (terrain: Terrain) => {
    if (isIslandDisabled(terrain))
      return DISABLED_COLOR.hex();

    if (terrain.type === TerrainType.Water)
      return WATER_COLOR.hex();

    return LIGHT_COLOR.mix(DARK_COLOR, terrain.height / 1000.0).hex();
  }

  const handleClick = (terrain: Terrain) => {
    if (terrain.type === TerrainType.Water || isIslandDisabled(terrain))
      return;

    const ground = terrain as Ground;

    if (ground.island === highestIsland)
      setGameStage(GameStage.Winner);
    else {
      ground.island.selected = true;
      
      if (tries == 1)
        setGameStage(GameStage.Loser);

      setTries(tries - 1);
    }
  }

  return (
    <>
      <div className="flex flex-row justify-between items-center w-[1680px]">
        <div className="min-w-72"/>
        <IsleHeights className="cursor-pointer" onClick={() => navigate("/")}/>
        <div className="w-72">
          <span className="self-center font-metamorphous text-lg">
            Tries Left: {tries}
          </span>
        </div>
      </div>
      <div className="flex flex-row gap-8">
        <div className="grid grid-cols-30 border border-white">
          {map.terrain.map(row => row.map(terrain =>
            <div
              className={cn(
                "flex w-14 h-7 justify-center items-center border p-1 border-transparent border-solid",
                isIslandHovered(terrain) && isGroundAndWaterUp(terrain) && `border-t-[#f6c732]`,
                isIslandHovered(terrain) && isGroundAndWaterBottom(terrain) && `border-b-[#f6c732]`,
                isIslandHovered(terrain) && isGroundAndWaterLeft(terrain) && `border-l-[#f6c732]`,
                isIslandHovered(terrain) && isGroundAndWaterRight(terrain) && `border-r-[#f6c732]`,
              )}
              style={{backgroundColor: calculateBackground(terrain)}}
              onMouseEnter={() => terrain.type === TerrainType.Ground && setHoverIsland((terrain as Ground).island)}
              onMouseLeave={() => setHoverIsland(undefined)}
              onClick={() => handleClick(terrain)}
              key={terrain.row * 30 + terrain.column}
            >
              {/*{terrain.height}*/}
            </div>
          ))}
        </div>
        <Topology/>
      </div>
      <DialogSuccess open={gameStage === GameStage.Winner} onOpenChange={setGameStage} island={highestIsland} tries={tries}/>
      <DialogFailure open={gameStage === GameStage.Loser} onOpenChange={setGameStage}/>
    </>
  )
}

export default Game;
