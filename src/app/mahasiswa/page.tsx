
import { StudentProps } from "@/types"
import { json } from "stream/consumers"



export const metadata = {
    title: "Mahasiswa lucu",
    description: "asd"
}

async function getStudents() {
    const students = await fetch("http://localhost:5000/students", { cache: "no-store" })
    return students.json()
}

export default async function StudentsPage() {
    // const students: StudentProps[] = await getStudents()

    return (
        <div className="w-full">

            <div className="mx-auto">
                <div className="flex justify-center items-center">
                    <a href="#_" className="relative inline-block text-lg group">
                        <span className="relative z-10 block px-5 py-3 overflow-hidden font-medium leading-tight text-gray-800 transition-colors duration-300 ease-out border-2 border-gray-900 rounded-lg group-hover:text-white">
                            <span className="absolute inset-0 w-full h-full px-5 py-3 rounded-lg bg-gray-50"></span>
                            <span className="absolute left-0 w-48 h-48 -ml-2 transition-all duration-300 origin-top-right -rotate-90 -translate-x-full translate-y-12 bg-gray-900 group-hover:-rotate-180 ease"></span>
                            <span className="relative">Button Text</span>
                        </span>
                        <span className="absolute bottom-0 right-0 w-full h-12 -mb-1 -mr-1 transition-all duration-200 ease-linear bg-gray-900 rounded-lg group-hover:mb-0 group-hover:mr-0" data-rounded="rounded-lg"></span>
                    </a>
                </div>
                <div className="mx-auto">

                    <div className="flex justify-normal items-end">

                        <p>daftar mahasiswa lucu</p>
                        {/* {students.map((student, index) => (
                            <div>
                                <a href={`http://localhost:3000/mahasiswa/${student.id}`} target={"_self"} key={student.id} >{index + 1}. {student.name}</a>
                            </div>
                        ))
                        } */}
                    </div>
                </div>
            </div >
        </div>
    )
}
