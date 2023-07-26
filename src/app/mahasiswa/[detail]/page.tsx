import { StudentProps } from "@/types"

export const metadata = {
    title: "Mahasiswa Detail",
    description: "iya"
}

async function getOneStudent(studentId: number) {
    const student = await fetch(`http://localhost:5000/students/${studentId}`, { next: { revalidate: 10 } })
    return student.json()
}
export default async function DetailPage({ params }: { params: { detail: string } }) {
    const id = parseInt(params.detail)
    const student: StudentProps = await getOneStudent(id)

    return (
        <div>
            <p>aku mahasiswa dengan nama {student.name}</p>
        </div>
    )
}
