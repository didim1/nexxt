import { type MahasiswaProps } from "@/models/MahasiswaModel";
import mongoose, { Connection } from "mongoose";
import { NextResponse } from "next/server";

const connectMongoDB = async (
  service: Promise<
    NextResponse<{ msg: string; data?: MahasiswaProps | MahasiswaProps[] }>
  >
) => {
  await mongoose.connect(process.env.DATABASE_URL as string);

  try {
    return await service;
  } catch (error) {
    console.log(error);
  }
};

export default connectMongoDB;
