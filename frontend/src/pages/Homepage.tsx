import {useEffect, useState} from "react";
import axios from "axios";
import {LevelThumbnail} from "@/types/LevelTypes.ts";
import IsleHeights from "@/assets/icons/IsleHeights.tsx";
import LevelCard from "@/components/homepage/LevelCard.tsx";
import {Env} from "@/utils/utils.ts";

const Homepage = () => {
  const [levels, setLevels]   = useState<LevelThumbnail[]>();

  useEffect(() => {
    axios.get(`${Env.API_URL}/levels`)
      .then(response => {
        setLevels(response.data);
      });
  }, []);

  if (!levels)
    return <></>

  return (
    <div className="flex flex-col w-full justify-center items-center gap-10">
      <div className="flex flex-row justify-center items-center w-[1680px]">
        <IsleHeights/>
      </div>
      <div className="flex flex-row gap-8 flex-wrap justify-center mx-40">
        {levels.map(level =>
          <LevelCard name={level.name} thumbnail_id={level.thumbnail_id} key={level.thumbnail_id} />
        )}
      </div>
    </div>
  )
}

export default Homepage;
