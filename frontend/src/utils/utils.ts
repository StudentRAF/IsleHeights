import { type ClassValue, clsx } from "clsx"
import twMerge from "@/utils/twMerge.ts";

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}

export const Env = {
  API_URL: import.meta.env.ISLE_HEIGHTS_API_URL
}
