import { MahasiswaProps } from "@/models/MahasiswaModel"
import { type ResponseProps } from "@/types"

async function getStudents(): Promise<ResponseProps> {
  const response = await fetch("https://kampoes.vercel.app/api/mhs")
  return response.json()
}


export default async function Home() {
  const students = await getStudents()

  return (
    <main className="container border-white border-solid border h-72">
      <p className="font-extrabold text-3xl text-center mb-6">Daftar Mahasiswa Lucu</p>

    </main>
  )
}
