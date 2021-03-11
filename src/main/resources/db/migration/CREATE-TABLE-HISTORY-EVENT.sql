CREATE TABLE history_event (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type varchar(20) NOT NULL,
  subscription_id varchar(255),
  created_at timestamp DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE history_event
    ADD CONSTRAINT fk_history_event_registration
         FOREIGN KEY (registration_id) REFERENCES registration(id);