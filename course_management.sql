CREATE TABLE department (
    department_id INT NOT NULL AUTO_INCREMENT,
    department_name VARCHAR(255) NOT NULL,
    budget DECIMAL(10, 2) NOT NULL,
    start_date DATE NOT NULL,
    administrator VARCHAR(255) NOT NULL,
    PRIMARY KEY (department_id)
);

CREATE TABLE course (
    course_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    credit VARCHAR(255) NOT NULL,
    department_id INT NOT NULL,
    PRIMARY KEY (course_id),
    FOREIGN KEY (department_id) REFERENCES department(department_id)
);

CREATE TABLE onlinecourse (
    course_id INT NOT NULL,
    url VARCHAR(255) NOT NULL,
    PRIMARY KEY (course_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);

CREATE TABLE onsitecourse (
    course_id INT NOT NULL,
    location VARCHAR(255) NOT NULL,
    days INT NOT NULL,
    onsite_course_time DATE NOT NULL,
    PRIMARY KEY (course_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);

CREATE TABLE person (
    person_id INT NOT NULL AUTO_INCREMENT,
    last_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    hire_date DATE NOT NULL,
    enrollment_date DATE NOT NULL,
    PRIMARY KEY (person_id)
);

CREATE TABLE courseinstructor (
    course_id INT NOT NULL,
    person_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course(course_id),
    FOREIGN KEY (person_id) REFERENCES person(person_id)
);

CREATE TABLE studentgrade (
    enrollment_id INT NOT NULL AUTO_INCREMENT,
    course_id INT NOT NULL,
    student_id INT NOT NULL,
    grade INT NOT NULL,
    PRIMARY KEY (enrollment_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);

CREATE TABLE officeassignment (
    instructor_id INT NOT NULL AUTO_INCREMENT,
    location VARCHAR(255) NOT NULL,
    timestamps DATE NOT NULL,
    PRIMARY KEY (instructor_id)
);
