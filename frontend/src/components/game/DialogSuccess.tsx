import {Dialog, DialogContent, DialogDescription, DialogHeader, DialogTitle, DialogTrigger} from "@/components/common/Dialog.tsx";
import {GameStage, Island} from "@/types/GameTypes.ts";
import {Dispatch, SetStateAction} from "react";

export interface DialogSuccessProps {
  open: boolean;
  island?: Island;
  tries: number;
  onOpenChange: Dispatch<SetStateAction<GameStage>>
}

const DialogSuccess = ({ open, onOpenChange, island, tries } : DialogSuccessProps) => {
  return (
    <Dialog open={open} onOpenChange={() => onOpenChange(GameStage.End)}>
      <DialogContent className="p-12 justify-center">
        <DialogHeader>
          <DialogTitle className="flex justify-center text-3xl">
            YOU WON
          </DialogTitle>
        </DialogHeader>
        <DialogDescription />
        <span className="text-base">
          You found the island with the highest average height of <span className="font-bold">{island?.average.toFixed(2)}m</span> with {tries} tries left.
        </span>
        <DialogTrigger asChild >
          <button className="bg-amber-600 h-10 w-full rounded-3xl mt-4">
            Go to Home
          </button>
        </DialogTrigger>
      </DialogContent>
    </Dialog>
  )
}

export default DialogSuccess;
