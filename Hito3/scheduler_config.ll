; LLVM IR generado por TIME-FLOW Compiler (Hito 3 - Implementación Final)
target triple = "x86_64-pc-windows-msvc"

; Estructura de Tarea: { last_run_time: i64, period_ms: i64, status: i8 }
%task.struct = type { i64, i64, i8 }

declare i64 @runtime_get_time()
declare void @runtime_log_execution(ptr)

@.str.Data_Processing = private constant [33 x i8] c"[TASK EXECUTION] Data_Processing\00"
@.str.Sensor_Readings = private constant [33 x i8] c"[TASK EXECUTION] Sensor_Readings\00"
@.str.Send_Urgent_Alert = private constant [35 x i8] c"[TASK EXECUTION] Send_Urgent_Alert\00"
@.str.Log_Event = private constant [27 x i8] c"[TASK EXECUTION] Log_Event\00"
@.str.Start_Analysis = private constant [32 x i8] c"[TASK EXECUTION] Start_Analysis\00"
@.str.Cleanup = private constant [25 x i8] c"[TASK EXECUTION] Cleanup\00"

define void @task_Log_Event() {
  %strptr = getelementptr inbounds [27 x i8], ptr @.str.Log_Event, i64 0, i64 0
  call void @runtime_log_execution(ptr %strptr)
  ret void
}

@Log_Event_state = global %task.struct { i64 0, i64 0, i8 0 }
define void @task_Start_Analysis() {
  %strptr = getelementptr inbounds [32 x i8], ptr @.str.Start_Analysis, i64 0, i64 0
  call void @runtime_log_execution(ptr %strptr)
  ret void
}

@Start_Analysis_state = global %task.struct { i64 0, i64 0, i8 0 }
define void @task_Send_Urgent_Alert() {
  %strptr = getelementptr inbounds [35 x i8], ptr @.str.Send_Urgent_Alert, i64 0, i64 0
  call void @runtime_log_execution(ptr %strptr)
  ret void
}

@Send_Urgent_Alert_state = global %task.struct { i64 0, i64 0, i8 0 }
define void @task_Sensor_Readings() {
  %strptr = getelementptr inbounds [33 x i8], ptr @.str.Sensor_Readings, i64 0, i64 0
  call void @runtime_log_execution(ptr %strptr)
  ret void
}

@Sensor_Readings_state = global %task.struct { i64 0, i64 30000, i8 0 }
define void @task_Data_Processing() {
  %strptr = getelementptr inbounds [33 x i8], ptr @.str.Data_Processing, i64 0, i64 0
  call void @runtime_log_execution(ptr %strptr)
  ret void
}

@Data_Processing_state = global %task.struct { i64 0, i64 3600000, i8 0 }
define void @task_Cleanup() {
  %strptr = getelementptr inbounds [25 x i8], ptr @.str.Cleanup, i64 0, i64 0
  call void @runtime_log_execution(ptr %strptr)
  ret void
}

@Cleanup_state = global %task.struct { i64 0, i64 0, i8 0 }

; Función Principal (Scheduler Multiagente)
define i32 @main() {
entry:
  ; Simulación: Bucle del scheduler
  %i_ptr = alloca i32
  store i32 0, ptr %i_ptr
  br label %loop_condition

loop_condition:
  %i = load i32, ptr %i_ptr
  %loop_end = icmp slt i32 %i, 100
  br i1 %loop_end, label %scheduler_loop, label %exit

scheduler_loop:
  %current_time = call i64 @runtime_get_time()

  br label %check_Data_Processing

check_Data_Processing:
  %task_state_0 = load %task.struct, ptr @Data_Processing_state
  %last_run_0 = extractvalue %task.struct %task_state_0, 0
  %diff_0 = sub i64 %current_time, %last_run_0
  %period_ptr_0 = getelementptr inbounds %task.struct, ptr @Data_Processing_state, i32 0, i32 1
  %period_0 = load i64, ptr %period_ptr_0
  %ready_0 = icmp sge i64 %diff_0, %period_0
  br i1 %ready_0, label %execute_Data_Processing, label %check_Sensor_Readings

execute_Data_Processing:
  call void @task_Data_Processing()
  %time_ptr_0 = getelementptr inbounds %task.struct, ptr @Data_Processing_state, i32 0, i32 0
  store i64 %current_time, ptr %time_ptr_0
  br label %check_Sensor_Readings

check_Sensor_Readings:
  %task_state_1 = load %task.struct, ptr @Sensor_Readings_state
  %last_run_1 = extractvalue %task.struct %task_state_1, 0
  %diff_1 = sub i64 %current_time, %last_run_1
  %period_ptr_1 = getelementptr inbounds %task.struct, ptr @Sensor_Readings_state, i32 0, i32 1
  %period_1 = load i64, ptr %period_ptr_1
  %ready_1 = icmp sge i64 %diff_1, %period_1
  br i1 %ready_1, label %execute_Sensor_Readings, label %check_Send_Urgent_Alert

execute_Sensor_Readings:
  call void @task_Sensor_Readings()
  %time_ptr_1 = getelementptr inbounds %task.struct, ptr @Sensor_Readings_state, i32 0, i32 0
  store i64 %current_time, ptr %time_ptr_1
  br label %check_Send_Urgent_Alert

check_Send_Urgent_Alert:
  %task_state_2 = load %task.struct, ptr @Send_Urgent_Alert_state
  %last_run_2 = extractvalue %task.struct %task_state_2, 0
  %diff_2 = sub i64 %current_time, %last_run_2
  %period_ptr_2 = getelementptr inbounds %task.struct, ptr @Send_Urgent_Alert_state, i32 0, i32 1
  %period_2 = load i64, ptr %period_ptr_2
  %ready_2 = icmp sge i64 %diff_2, %period_2
  br i1 %ready_2, label %execute_Send_Urgent_Alert, label %check_Log_Event

execute_Send_Urgent_Alert:
  call void @task_Send_Urgent_Alert()
  %time_ptr_2 = getelementptr inbounds %task.struct, ptr @Send_Urgent_Alert_state, i32 0, i32 0
  store i64 %current_time, ptr %time_ptr_2
  br label %check_Log_Event

check_Log_Event:
  %task_state_3 = load %task.struct, ptr @Log_Event_state
  %last_run_3 = extractvalue %task.struct %task_state_3, 0
  %diff_3 = sub i64 %current_time, %last_run_3
  %period_ptr_3 = getelementptr inbounds %task.struct, ptr @Log_Event_state, i32 0, i32 1
  %period_3 = load i64, ptr %period_ptr_3
  %ready_3 = icmp sge i64 %diff_3, %period_3
  br i1 %ready_3, label %execute_Log_Event, label %check_Start_Analysis

execute_Log_Event:
  call void @task_Log_Event()
  %time_ptr_3 = getelementptr inbounds %task.struct, ptr @Log_Event_state, i32 0, i32 0
  store i64 %current_time, ptr %time_ptr_3
  br label %check_Start_Analysis

check_Start_Analysis:
  %task_state_4 = load %task.struct, ptr @Start_Analysis_state
  %last_run_4 = extractvalue %task.struct %task_state_4, 0
  %diff_4 = sub i64 %current_time, %last_run_4
  %period_ptr_4 = getelementptr inbounds %task.struct, ptr @Start_Analysis_state, i32 0, i32 1
  %period_4 = load i64, ptr %period_ptr_4
  %ready_4 = icmp sge i64 %diff_4, %period_4
  br i1 %ready_4, label %execute_Start_Analysis, label %check_Cleanup

execute_Start_Analysis:
  call void @task_Start_Analysis()
  %time_ptr_4 = getelementptr inbounds %task.struct, ptr @Start_Analysis_state, i32 0, i32 0
  store i64 %current_time, ptr %time_ptr_4
  br label %check_Cleanup

check_Cleanup:
  %task_state_5 = load %task.struct, ptr @Cleanup_state
  %last_run_5 = extractvalue %task.struct %task_state_5, 0
  %diff_5 = sub i64 %current_time, %last_run_5
  %period_ptr_5 = getelementptr inbounds %task.struct, ptr @Cleanup_state, i32 0, i32 1
  %period_5 = load i64, ptr %period_ptr_5
  %ready_5 = icmp sge i64 %diff_5, %period_5
  br i1 %ready_5, label %execute_Cleanup, label %loop_counter

execute_Cleanup:
  call void @task_Cleanup()
  %time_ptr_5 = getelementptr inbounds %task.struct, ptr @Cleanup_state, i32 0, i32 0
  store i64 %current_time, ptr %time_ptr_5
  br label %loop_counter

loop_counter:
  %i_next = add i32 %i, 1
  store i32 %i_next, ptr %i_ptr
  br label %loop_condition

exit:
  ret i32 0
}
