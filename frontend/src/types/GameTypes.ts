export enum TerrainType {
  Ground = "Ground",
  Water  = "Water"
}

export enum GameStage {
  InProgress = "InProgress",
  Loser      = "Loser",
  Winner     = "Winner",
  End        = "End"
}

export type Cell = {
  row:    number;
  column: number;
}

export type Terrain = {
  row:     number;
  column:  number;
  height:  number;
  type:    TerrainType;
}

export type Water = Terrain & {
  type: TerrainType.Water;
};

export type Ground = Terrain & {
  type:   TerrainType.Ground;
  island: Island;
};

export type Island = {
  id:       number;
  height:   number;
  count:    number;
  average:  number;
  selected: boolean;
}

export type Map = {
  terrain: Terrain[][];
  island: Island[];
};


