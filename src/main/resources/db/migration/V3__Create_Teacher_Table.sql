CREATE TABLE teacher (
id INT AUTO_INCREMENT PRIMARY KEY,
teacher_name VARCHAR(50) NOT NULL,
subject_id INT,
FOREIGN KEY (subject_id) REFERENCES subject(id)
);