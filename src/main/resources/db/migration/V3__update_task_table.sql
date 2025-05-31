ALTER TABLE task
    ADD COLUMN category_id BIGINT,
    ADD CONSTRAINT fk_task_category
        FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE;




