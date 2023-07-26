import { StudentProps } from "@/types";
import mongoose, { Schema, InferSchemaType, Types } from "mongoose";

const MahasiswaSchema = new Schema<StudentProps>(
  {
    name: { type: String },
    age: { type: Number },
  },
  {
    timestamps: true,
  }
);

export type MahasiswaProps = InferSchemaType<typeof MahasiswaSchema>;

const Mahasiswa =
  mongoose.models.Mahasiswa ||
  mongoose.model<StudentProps>("Mahasiswa", MahasiswaSchema);

export default Mahasiswa;
