import connectMongoDB from "@/lib/mongodb";
import {
  createStudent,
  deleteStudent,
  getStudent,
  updateStudent,
} from "@/services/crudMhs";
import type { StudentProps } from "@/types";
import { type NextRequest } from "next/server";

export async function GET(req: NextRequest) {
  const nim = req.nextUrl.searchParams.get("nim");
  return await connectMongoDB(getStudent(nim));
}

export async function POST(req: NextRequest) {
  const data: StudentProps = await req.json();
  return await connectMongoDB(createStudent(data));
}

export async function PATCH(req: NextRequest) {
  const nim = req.nextUrl.searchParams.get("nim");
  const data: StudentProps = await req.json();
  return await connectMongoDB(updateStudent(nim, data));
}

export async function DELETE(req: NextRequest) {
  const nim = req.nextUrl.searchParams.get("nim");
  return await connectMongoDB(deleteStudent(nim));
}
