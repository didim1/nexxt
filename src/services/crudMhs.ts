import Mahasiswa, { type MahasiswaProps } from "@/models/MahasiswaModel";
import { type StudentProps } from "@/types";
import { NextResponse } from "next/server";

export async function getStudent(nim: string | null) {
  if (!nim) {
    const mahasiswas = await Mahasiswa.find<MahasiswaProps>();
    return NextResponse.json({ msg: "Get All Student", data: mahasiswas });
  }

  try {
    const mahasiswa = await Mahasiswa.findById<MahasiswaProps>(nim);
    if (!mahasiswa)
      return NextResponse.json({ msg: "Student Not Found" }, { status: 404 });
    return NextResponse.json({ msg: "Get One Student", data: mahasiswa });
  } catch (error) {
    return NextResponse.json({ msg: "error" }, { status: 500 });
  }
}

export async function createStudent(data: StudentProps) {
  try {
    await Mahasiswa.create(data);
    return NextResponse.json({ msg: "Student created" }, { status: 201 });
  } catch (error) {
    return NextResponse.json({ msg: "error" }, { status: 500 });
  }
}

export async function updateStudent(nim: string | null, data: StudentProps) {
  try {
    const isFound = await Mahasiswa.findByIdAndUpdate(nim, data);
    if (!isFound)
      return NextResponse.json({ msg: "Student Not Found" }, { status: 404 });

    return NextResponse.json({ msg: "Student Updated" });
  } catch (error) {
    return NextResponse.json({ msg: "error" }, { status: 500 });
  }
}

export async function deleteStudent(nim: string | null) {
  try {
    const isFound = await Mahasiswa.findByIdAndDelete(nim);
    if (!isFound)
      return NextResponse.json({ msg: "Student Not Found" }, { status: 404 });
    return NextResponse.json({ msg: "Student Deleted" });
  } catch (error) {
    return NextResponse.json({ msg: "error" }, { status: 500 });
  }
}
