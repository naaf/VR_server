

select * from  utilisateur ;
insert into utilisateur (name, surname, email, password, role, type_habitant)
values
('linkedin', 'linkedin', 'dantlinkedin@gmail.com', 'password', 'place jussieu', 'Paris');

update utilisateur set role = 'GARDIEN';

update utilisateur set type_habitant = 'PRESIDENT_COPROPRIETE';
PRESIDENT_COPROPRIETE

delete FROM utilisateur ;