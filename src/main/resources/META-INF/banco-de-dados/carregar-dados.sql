insert into curso (id, nome) values (1, 'Especialista JPA');

insert into modulo (id, curso_id, nome) values (1, 1, 'Introdução');

insert into aula (id, modulo_id, nome) values (1, 1, 'Apresentação do Curso');
insert into aula (id, modulo_id, nome) values (2, 1, 'Introdução ao JPA');

insert into aluno (id, nome) values (1, 'João da Silva');

insert into curso_aluno (curso_id, aluno_id) values (1, 1);