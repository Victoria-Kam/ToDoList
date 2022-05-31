package Logic.Enum;

public enum TaskParameters {    // перечисление для вывода на консоль, чтобы пользователь знал что именно он может изменить в задаче

    TYPE {
        @Override
        public String toString() {
            return "Тип задачи";
        }
    },

    TITLE {
        @Override
        public String toString() {
            return "Заголовок задачи";
        }
    },

    CONTENT {
        @Override
        public String toString() {
            return "Сама задача";
        }
    },

    STATUS {
        @Override
        public String toString() {
            return "Статус задачи";
        }
    }
}
