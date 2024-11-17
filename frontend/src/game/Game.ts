import {Level} from "@/types/LevelTypes.ts";
import {Cell, Ground, Island, Map, Terrain, TerrainType, Water} from "@/types/GameTypes.ts"

export const buildMap = (level: Level) => {
  const map: Map = {
    terrain: [],
    island: []
  };
  const maxRows    = 30;
  const maxColumns = 30;

  for (let row = 0; row < maxRows; ++row) {
    const terrainRow: Terrain[] = [];

    for (let column = 0; column < maxColumns; ++column)
      terrainRow.push(createTerrain(row, column, level.islands[row * maxColumns + column]));

    map.terrain[row] = terrainRow;
  }

  const visited = new Array(30).fill(false)
                                       .map(() => new Array(30)
                                       .fill(false));

  for (let row = 0; row < maxRows; ++row)
    for (let column = 0; column < maxColumns; ++column)
      if (!visited[row][column] && map.terrain[row][column].type === TerrainType.Ground)
        connectIsland(row, column, map, visited);

  return map;

}

//region Build Terrain

const createTerrain = (row: number, column: number, height: number) => {
  if (height == 0)
    return createWater(row, column);

  return createGround(row, column, height);
}

const createWater = (row: number, column: number) => {
  return {
    row: row,
    column: column,
    height: 0,
    type: TerrainType.Water
  } as Water;
}

const createGround = (row: number, column: number, height: number) => {
  return {
    row: row,
    column: column,
    height: height,
    type: TerrainType.Ground,
  } as Ground;
}

//endregion Build Terrain

//region Connect Islands

const directions: Cell[] = [
  { row: -1, column:  0 },
  { row:  1, column:  0 },
  { row:  0, column: -1 },
  { row:  0, column:  1 },
]

const connectIsland = (row: number, column: number, map: Map, visited: boolean[][])=> {
  if (map.terrain[row][column].type !== TerrainType.Ground)
    throw new Error("To connect island, you can only use ground terrain!");

  visited[row][column] = true;

  const groundStack: Ground[] = [map.terrain[row][column] as Ground]
  const island: Island = {
    id: map.island.length,
    height:   0,
    count:    0,
    average:  0,
    selected: false
  }

  while (true) {
    const currentGround = groundStack.pop();

    if (!currentGround)
      break;

    island.count++;
    island.height += currentGround.height;

    currentGround.island = island;

    directions.forEach(direction => {
      const newRow = currentGround.row + direction.row;
      const newColumn = currentGround.column + direction.column;

      if (newRow < 0 || newRow >= 30 || newColumn < 0 || newColumn >= 30 || visited[newRow][newColumn] || map.terrain[newRow][newColumn].type === TerrainType.Water)
        return;

      groundStack.push(map.terrain[newRow][newColumn] as Ground);
      visited[newRow][newColumn] = true;
    });
  }

  island.average = island.height / island.count;

  map.island.push(island);
}

//endregion Connect Islands

