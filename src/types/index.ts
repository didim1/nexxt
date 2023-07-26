import { MahasiswaProps } from "@/models/MahasiswaModel";
import { Types } from "mongoose";

export interface StudentProps {
  _id?: Types.ObjectId;
  name?: string;
  age?: number;
}

export interface ResponseProps {
  msg: string;
  data: MahasiswaProps[] | MahasiswaProps;
}
