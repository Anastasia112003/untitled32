public class Worker {
    private OnTaskDoneListener callback;
    private  OnTaskErrorListener errorCallback;
 //   public Worker(OnTaskErrorListener errorCallback){
  //      this.errorCallback=errorCallback;
 // }

    public Worker(OnTaskDoneListener callback,OnTaskErrorListener errorCallback) {
        this.callback = callback;
       this.errorCallback=errorCallback;
    }


    public void start() {

        for (int i = 0; i < 100; i++) {
            if(i==33){errorCallback.onError("Error!!!!");}
            else {
            callback.onDone("Task " + i + " is done");}
        }
    }
   // Обратите внимание на то, что каждая итерация цикла означает выполнение
   // задачи, результат который передается через метод onDone() функционального интерфейса OnTaskDoneListener.
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener{
        void onError(String message);
    }

   //Однако может случиться так, что выполнение одной из задач может закончиться неуспешно.
    // Смоделируйте ситуацию, в которой 33 задача закончится неуспешно, и выведите информацию об этом в класс Main.
    // Для этого создайте новый функциональный интерфейс OnTaskErrorListener, определите там метод onError().
    // Добавьте в класс Worker переменную errorCallback типа OnTaskErrorListener.
    // Значение переменной передавайте так же через конструктор.
    // Таким образом, в консоле после выполнения вашего кода все задачи, кроме 33,
    // должны закончиться успешно, а 33 - оповестит об ошибке.
}
