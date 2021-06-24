import { Anwser } from "./anwser";

export class Question {
    id: number;
    text: string;
    level: string;
    ansCorrect: number;
    idUser: number;
    anwserDTOList?: [
        {
            id?:number;
            textanwser?:string,
            trueOrFalse?:boolean;
        }
    ];

}