select COUNT(id1) as coincidencias from (select c.id id1, c2.id id2, c2.hora_inicio , c.hora_final  from citapeluqueria c 
inner join citapeluqueria c2 
on (
    (c.hora_inicio < c2.hora_inicio and c2.hora_inicio < c.hora_final and c.hora_final < c2.hora_final)
    and c.id != c2.id
)
union 
select c.id id1, c2.id id2, c2.hora_inicio , c2.hora_final  from citapeluqueria c 
inner join citapeluqueria c2 
on (
    (c.hora_inicio<= c2.hora_inicio and c2.hora_final <= c.hora_final)
    and c.id != c2.id
)) as r
where (r.hora_inicio <:hora_inicio and :hora_inicio < r.hora_final and r.hora_final <:hora_final)
   or (:hora_inicio < r.hora_inicio and r.hora_inicio < :hora_final and :hora_final < r.hora_final)
   or (r.hora_inicio <= :hora_inicio and :hora_final <= r.hora_final)
   or (:hora_inicio <= r.hora_inicio and r.hora_final <= :hora_final)