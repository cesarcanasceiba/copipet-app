select sp.id, sp.nombre from serviciopeluqueria as sp inner join citapeluqueria_servicios as cps on (sp.id = cps.serviciopeluqueria_id) where citapeluqueria_id=:citaId