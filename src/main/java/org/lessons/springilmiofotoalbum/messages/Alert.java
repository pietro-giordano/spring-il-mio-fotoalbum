package org.lessons.springilmiofotoalbum.messages;

public class Alert {
      private final AlertType type;
      private final String message;

      public Alert(AlertType type, String message) {
            this.type = type;
            this.message = message;
      }

      public AlertType getType() {
            return type;
      }

      public String getMessage() {
            return message;
      }
}
