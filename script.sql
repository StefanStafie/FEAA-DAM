INSERT INTO public.echipe (id,departament, nume_echipa) VALUES
(8,'SUPPORT', 'Support Team 1'),
(2,'FRONTEND_DEVELOPMENT', 'Frontend Team 1'),
(6,'QA', 'QA Team 1'),
(1,'BACKEND_DEVELOPMENT', 'Backend Team 1'),
(4,'FRONTEND_DEVELOPMENT', 'Frontend Team 2'),
(5,'INFRASTRUCTURE', 'Infrastructure Team 2'),
(7,'QA', 'QA Team 2'),
(3,'BACKEND_DEVELOPMENT', 'Backend Team 2');

INSERT INTO public.angajati (id, contact, departament, prenume, nume, functie, aptitudini, id_echipa)
VALUES
  (1, 'contact1@example.com', 'BACKEND_DEVELOPMENT', 'Ion', 'Popescu', 'Software Engineer', 'Java, Spring', 1),
  (2, 'contact2@example.com', 'QA', 'Ana', 'Dumitrescu', 'QA Analyst', 'Testing, Automated Testing', 6),
  (3, 'contact3@example.com', 'INFRASTRUCTURE', 'Mihai', 'Ionescu', 'System Administrator', 'Linux, Networking', 5),
  (4, 'contact4@example.com', 'FRONTEND_DEVELOPMENT', 'Elena', 'Gheorghiu', 'Frontend Developer', 'HTML, CSS, JavaScript', 2),
  (5, 'contact5@example.com', 'INFRASTRUCTURE', 'Adrian', 'Stanciu', 'Database Administrator', 'SQL, MongoDB', 5),
  (6, 'contact6@example.com', 'BACKEND_DEVELOPMENT', 'Mihaela', 'Radulescu', 'DevOps Engineer', 'Docker, Jenkins', 3),
  (7, 'contact7@example.com', 'SUPPORT', 'Cristian', 'Marinescu', 'Security Analyst', 'Cybersecurity, Penetration Testing', 8),
  (8, 'contact8@example.com', 'BACKEND_DEVELOPMENT', 'Roxana', 'Iancu', 'Full Stack Developer', 'Java, React', 1),
  (9, 'contact9@example.com', 'QA', 'Florin', 'Popa', 'Automation Engineer', 'Selenium, JUnit', 7),
  (10, 'contact10@example.com', 'INFRASTRUCTURE', 'Simona', 'Chirita', 'Software Architect', 'Microservices, Architecture', 5);
