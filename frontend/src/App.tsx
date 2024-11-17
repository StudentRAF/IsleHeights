import Game from "@/pages/Game.tsx";
import {Route, Routes} from "react-router-dom";
import Homepage from "@/pages/Homepage.tsx";

const App = () => {
  return (
    <main className="flex flex-col flex-grow items-center pt-8 pb-4 gap-4">
      <Routes>
        <Route path="/"            element={ <Homepage /> } />
        <Route path="/game/:level" element={ <Game /> } />
      </Routes>
    </main>
  );
}

export default App
