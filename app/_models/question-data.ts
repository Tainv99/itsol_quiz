import {AnswerData} from './answer-data';

export interface QuestionData {
  id?: number;
  text?: string;
  answerList?: AnswerData[];
}
