SELECT max(n.id) as id, n.autorizador, n.servico_id, n.situacao, s.nome, n.dt
	FROM public.statusnfe n
	inner join servico s on s.id = n.servico_id
	GROUP BY n.autorizador, n.servico_id, n.situacao, s.nome, n.dt
	ORDER BY n.autorizador

SELECT max(n.id) as id, n.autorizador, n.servico_id, n.situacao, s.nome, n.dt
	FROM public.statusnfe n
	inner join servico s on s.id = n.servico_id
	WHERE n.autorizador = 'PR'
	GROUP BY s.id, n.autorizador, n.servico_id, n.situacao, s.nome, n.dt
	ORDER BY s.id

--count indisponibilidade
SELECT autorizador from (
SELECT count(n.id), n.autorizador, n.situacao
	FROM public.statusnfe n
	inner join servico s on s.id = n.servico_id
	WHERE n.situacao != 'VERDE' and n.situacao != ''
	GROUP BY n.autorizador, n.situacao
	limit 1
) as x


SELECT max(n.id) as id, n.autorizador, n.servico_id, n.situacao, s.nome, n.dt
	FROM public.statusnfe n
	inner join servico s on s.id = n.servico_id
	where n.dt between '2021-07-17 23:24:10' and '2021-07-17 23:26:25'	
	GROUP BY n.autorizador, n.servico_id, n.situacao, s.nome, n.dt
	ORDER BY n.autorizador
	
	
	
	