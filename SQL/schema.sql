
-- 1. CLEANUP (Drop tables in reverse order to handle dependencies) 
DROP VIEW IF EXISTS leaderboard_view; 
 
DROP TABLE IF EXISTS Results; 
 
DROP TABLE IF EXISTS Answers; 
 
DROP TABLE IF EXISTS Test_Questions; 
 
DROP TABLE IF EXISTS Questions; 
 
DROP TABLE IF EXISTS Tests; 
 
DROP TABLE IF EXISTS Users; 
 
-- 2. CREATE TABLES 
CREATE TABLE 
    Users ( 
        user_id serial PRIMARY KEY, 
        firstname VARCHAR(20) NOT NULL, 
        lastname VARCHAR(20) NOT NULL, 
        username VARCHAR(255) UNIQUE NOT NULL, 
        password VARCHAR(255) NOT NULL, 
        user_type VARCHAR(20) DEFAULT 'STUDENT' CHECK (user_type IN ('STUDENT', 'CREATOR', 'MANAGER')) 
    ); 
 
CREATE TABLE 
    Tests ( 
        test_id SERIAL PRIMARY KEY, 
        title VARCHAR(100) NOT NULL, 
        creator_id INT NOT NULL, 
        CONSTRAINT fk_test_creator FOREIGN KEY (creator_id) REFERENCES Users (user_id) ON DELETE CASCADE 
    ); 
 
CREATE TABLE 
    Questions ( 
        question_id SERIAL PRIMARY KEY, 
        question_text TEXT NOT NULL, 
        points INT DEFAULT 1 
    ); 
 
CREATE TABLE 
    Answers ( 
        answer_id SERIAL PRIMARY KEY, 
        question_id INT NOT NULL, 
        answer_text TEXT NOT NULL, 
        is_correct BOOLEAN DEFAULT FALSE, 
        CONSTRAINT fk_answer_question FOREIGN KEY (question_id) REFERENCES Questions (question_id) ON DELETE CASCADE 
    ); 
 
CREATE TABLE 
    Test_Questions ( 
        test_id INT NOT NULL, 
        question_id INT NOT NULL, 
        PRIMARY KEY (test_id, question_id), 
        CONSTRAINT fk_tq_test FOREIGN KEY (test_id) REFERENCES Tests (test_id) ON DELETE CASCADE, 
        CONSTRAINT fk_tq_question FOREIGN KEY (question_id) REFERENCES Questions (question_id) ON DELETE CASCADE 
    ); 
 
CREATE TABLE 
    Results ( 
        result_id SERIAL PRIMARY KEY, 
        user_id INT NOT NULL, 
        test_id INT NOT NULL, 
        score INT NOT NULL, 
        CONSTRAINT fk_result_user FOREIGN KEY (user_id) REFERENCES Users (user_id) ON DELETE CASCADE, 
        CONSTRAINT fk_result_test FOREIGN KEY (test_id) REFERENCES Tests (test_id) ON DELETE CASCADE 
    ); 
 
-- 3. INDEXES FOR PERFORMANCE 
CREATE INDEX idx_Test_creator ON Tests (creator_id); 
 
CREATE INDEX idx_Answer_question ON Answers (question_id); 
 
CREATE INDEX idx_Result_user ON Results (user_id); 
 
CREATE INDEX idx_Result_test ON Results (test_id); 
 
-- 4. VIEW (Complex Query Requirement) 
-- Functionality: Display the highest score and user account name for a test among all Users. 
CREATE VIEW 
    leaderboard_view AS 
SELECT 
    t.title AS test_title, 
    u.username AS top_user, 
    r.score AS high_score 
FROM 
    Results r 
    JOIN Users u ON r.user_id = u.user_id 
    JOIN Tests t ON r.test_id = t.test_id 
WHERE 
    (r.test_id, r.score) IN ( 
        SELECT 
            test_id, 
            MAX(score) 
        FROM 
            Results 
        GROUP BY 
            test_id 
    ); 
 
-- 5. INSERT DATA 
-- Insert Users 
INSERT INTO 
    Users ( 
        firstname, 
        lastname, 
        username, 
        password, 
        user_type 
    ) 
VALUES 
    ( 
        'Alice', 
        'Johnson', 
        'alice_admin', 
        'pass123', 
        'CREATOR' 
    ), 
    ( 
        'Bob', 
        'Miller', 
        'bob_student', 
        'pass123', 
        'STUDENT' 
    ), 
    ( 
        'Charlie', 
        'Davis', 
        'charlie_new', 
        'pass123', 
        'STUDENT' 
    ), 
    ( 
        'Dave', 
        'Wilson', 
        'dave_manager', 
        'securePass1', 
        'MANAGER' 
    ); 
 
-- Insert Tests 
INSERT INTO 
    Tests (title, creator_id) 
VALUES 
    ('Java Basics', 1), 
    ('SQL Fundamentals', 1); 
 
-- Insert Questions 
INSERT INTO 
    Questions (question_text, points) 
VALUES 
    ('What is the size of an int in Java?', 5), 
    ('Which SQL clause is used to filter rows?', 10), 
    ('Is Java object-oriented?', 5); 
 
-- Insert Answers 
INSERT INTO 
    Answers (question_id, answer_text, is_correct) 
VALUES 
    (1, '32 bits', TRUE), 
    (1, '64 bits', FALSE), 
    (1, '16 bits', FALSE), 
    (2, 'WHERE', TRUE), 
    (2, 'SELECT', FALSE), 
    (2, 'GROUP BY', FALSE), 
    (3, 'Yes', TRUE), 
    (3, 'No', FALSE); 
 
-- Link Questions to Tests 
INSERT INTO 
    Test_Questions (test_id, question_id) 
VALUES 
    (1, 1), 
    (1, 3); 
 
-- Insert Results 
INSERT INTO 
    Results (user_id, test_id, score) 
VALUES 
    (2, 1, 10), 
    (2, 2, 0), 
    (3, 1, 5); 
