import { ChangeEvent } from "react";
import { Task } from "../types/task";

type Props = {
    task?: Task;
    onChangeName: (event: ChangeEvent<HTMLInputElement>) => void;
}

export default function HeroDetail({ task, onChangeName }: Props) {
    if (!task) return null;
    return (
        <>
            <h2 className="text-2xl">Details</h2>
            <div>
                <span className="font-bold">ID:</span>{task.id}
            </div>
            <div className="space-x-2">
                <span className="font-bold">Name:</span>
                <span className="uppercase">{task.taskTitle}</span>
            </div>
            <div className="flex flex-col gap-2 mt-3 border-t">
                <label>Hero name</label>
                <input type="text" placeholder="name" className="border" value={task.taskTitle} onChange={onChangeName} />
            </div>
        </>
    )
}