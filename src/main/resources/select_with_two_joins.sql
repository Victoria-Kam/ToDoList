select tt.name as type,task.title, task.content, ts.name
from task inner join task_type  tt on tt.idtasktype = task.idtasktype
          inner join task_status ts on task.idtaskstatus = ts.idtaskstatus