import { ChangeEvent, useEffect, useState } from "react"
import HeroDetail from "./components/HeroDetail";
import { Task } from "./types/task";


export default function App() {
  const [tasks, setTasks] = useState<Task[]>([]);
  const [selectedTaskId, setSelectedTaskId] = useState<number | null>(null)

  useEffect(() => {
    fetch('/api/task/list',{method:"GET",credentials:"include"}).then(res => {
      return res.json();
    }).then(data => {
      if (data && data.data) {
        const transformedTask: Task[] = data.data.map((task: Task) => ({
          ...task,
          assigneDate: new Date(task.assigneDate),
          dueDate: new Date(task.dueDate),
        }));
        setTasks(transformedTask);
      }
    })
  }, [])

  const selectedTask = tasks.find(task => task.id === selectedTaskId)

  const handleNameChange = (event: ChangeEvent<HTMLInputElement>) => {
    const updateName = event.target.value;

    setTasks(prevHeroes => prevHeroes.map(hero => {
      if (hero.id === selectedTaskId) {
        return { ...hero, name: updateName }
      }
      return hero;
    }))
  }

  const handleSelectHero = (id: number) => {
    setSelectedTaskId(id);
  }

  return (
    <div className="container mt-5 mx-auto">
      <h2 className="text-2xl">My heroes</h2>
      <ul className="flex flex-col gap-2 my-3">
        {tasks.map(task => (
          <li className="flex cursor-pointer" key={task.id} onClick={() => handleSelectHero(task.id)}>
            <span className="bg-slate-700 text-white rounded-l p-2">{task.id}</span>
            <span className="p-2 bg-slate-300 rounded-r w-1/4">{task.taskTitle}</span>
          </li>
        ))}
      </ul>

      <HeroDetail task={selectedTask} onChangeName={handleNameChange} />
    </div>
  )
}