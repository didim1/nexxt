import { Types } from "mongoose";

export interface StudentProps {
  _id?: Types.ObjectId;
  name?: string;
  age?: number;
}
