import {useNavigate} from "react-router-dom";

export interface LevelCardProps {
  name:         string;
  thumbnail_id: number;
}

const LevelCard = ({ name, thumbnail_id }: LevelCardProps) => {
  const navigate = useNavigate();

  return (
    <div
      className="relative rounded-3xl w-[480px] overflow-clip border-2 border-transparent hover:border-amber-500 hover:cursor-pointer"
      onClick={() => navigate(`/game/${name}`)}
    >
      <img src={`http://localhost:8000/api/v1/images/raw/${thumbnail_id}`} alt={name} className="brightness-50"/>
      <span className="absolute left-[50%] top-[45%] translate-x-[-50%] translate-y-[-50%] z-50 font-metamorphous font-bold text-4xl">
        {name}
      </span>
    </div>
  )
}

export default LevelCard;
