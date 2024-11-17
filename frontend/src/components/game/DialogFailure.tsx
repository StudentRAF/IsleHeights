import {GameStage} from "@/types/GameTypes.ts";
import {Dispatch, SetStateAction} from "react";
import {Dialog, DialogContent, DialogDescription, DialogHeader, DialogTitle, DialogTrigger} from "@/components/common/Dialog.tsx";

export interface DialogFailureProps {
  open: boolean;
  onOpenChange: Dispatch<SetStateAction<GameStage>>
}

const DialogFailure = ({ open, onOpenChange}: DialogFailureProps) => {
  return (
    <Dialog open={open} onOpenChange={() => onOpenChange(GameStage.End)}>
      <DialogContent className="p-12 justify-center">
        <DialogHeader>
          <DialogTitle className="flex justify-center text-3xl">
            YOU LOST
          </DialogTitle>
        </DialogHeader>
        <DialogDescription />
        <span className="text-base">
          You failed to find the highest average island!
        </span>
        <DialogTrigger asChild>
          <button className="bg-amber-600 h-10 w-full rounded-3xl mt-4">
            Go to Home
          </button>
        </DialogTrigger>
      </DialogContent>
    </Dialog>
  )
}

export default DialogFailure;
