--
-- PostgreSQL database dump
--

\restrict s01DECNSvNj4SCGr9aWLXskvXf0qC9PlzVBwkHNXSviRBmlQyYeWAWP2ZnKVqRE

-- Dumped from database version 18.0
-- Dumped by pg_dump version 18.0

-- Started on 2026-04-27 02:28:43

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 220 (class 1259 OID 18100)
-- Name: new_users; Type: TABLE; Schema: public; Owner: ?
--

CREATE TABLE public.new_users (
    id integer NOT NULL,
    email character varying(255),
    name character varying(255),
    password character varying(255)
);


ALTER TABLE public.new_users OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 18091)
-- Name: task; Type: TABLE; Schema: public; Owner: ?
--

CREATE TABLE public.task (
    id integer NOT NULL,
    deadline character varying(255),
    description character varying(255),
    priority character varying(255),
    status boolean NOT NULL,
    title character varying(255),
    user_id integer
);


ALTER TABLE public.task OWNER TO postgres;

--
-- TOC entry 4965 (class 0 OID 18100)
-- Dependencies: 220
-- Data for Name: new_users; Type: TABLE DATA; Schema: public; Owner: ?
--

COPY public.new_users (id, email, name, password) FROM stdin;
1	ethan@test.com	Ethan Miller	$2a$10$Y/zdBuopdGK3wj5A5/1lx.Qwt9e7oMg4qS.WSeglPwvT9cGkMWPU6
2	olivia@test.com	Olivia Johnson	$2a$10$7auWnhzs9liRHfldkBfMY.Tj4uAuKYFy8ujQ6trpu6sykrcBA1/Ra
3	liam@test.com	Liam Anderson	$2a$10$QBr0nqTu7kdwbmioUqu7feETs8c9YQwpe3efHgklueNHMd.0OXeoG
4	sophia@test.com	Sophia Martinez	$2a$10$/y.HL94xdpwLJI.68n37g.Eh90DHTXuzbmYXswuPP0vlVjq7p8bMy
5	noah@test.com	Noah Wilson	$2a$10$DVxXquXqwLfvrYtUNEI4TOiAkFbjco1Y4nQHW9lVTuOu9iNAOjvOe
6	emma@test.com	Emma Taylor	$2a$10$DEzQ3eX9zCNmv6BwN1MJbO5QTUHMCn8aylGNdjzFZBH33goeWvCk2
7	james@test.com	James Brown	$2a$10$MR1yMzBNiJtwbHxTmhY7Z.J/sx1rA/4Ez1iknNsOohIxfUz.osuVi
8	isabella@test.com	Isabella Davis	$2a$10$s1mRBl3riHhnrpUqP/X09O9AfpWM2VQDLi2PRl//uvYkWDJywK8dm
9	william@test.com	William Garcia	$2a$10$iWtrAhE4LE0sZYMZq8R2dObUi6bPC5qoKIfQAsOJHVoz3sJT32Acm
10	ava@test.com	Ava Rodriguez	$2a$10$HbvOa7jFD7ngZFQOHM5xquNEuillrjsiDkDnWZ39fauCKoI7gbMnu
\.


--
-- TOC entry 4964 (class 0 OID 18091)
-- Dependencies: 219
-- Data for Name: task; Type: TABLE DATA; Schema: public; Owner: ?
--

COPY public.task (id, deadline, description, priority, status, title, user_id) FROM stdin;
1	2026-04-27	Complete weekly project report	High	f	Finish Report	1
2	2026-04-28	Attend backend sync meeting	Medium	t	Team Meeting	1
3	2026-04-29	Review pull requests	High	f	Code Review	1
4	2026-04-30	Test APIs in Postman	Medium	f	API Testing	1
5	2026-05-01	Add setup steps	Low	t	Update README	1
6	2026-05-02	Remove duplicate records	Medium	f	Database Cleanup	2
7	2026-05-03	Debug JWT login issue	High	f	Fix Login Bug	2
8	2026-05-04	Document APIs	Medium	t	Add Swagger	2
9	2026-05-05	Clean service methods	Low	f	Refactor Service	2
10	2026-05-06	Deploy Spring Boot app	High	f	Deploy Backend	2
11	2026-05-07	Test service layer	High	f	Write Unit Tests	3
12	2026-05-08	Check JWT filter	High	t	Review Security	3
13	2026-05-09	Add request response objects	Medium	f	Create DTOs	3
14	2026-05-10	Validate task inputs	Medium	f	Fix Validation	3
15	2026-05-11	Review console errors	Low	t	Check Logs	3
16	2026-05-12	Plan analytics response	Medium	f	Design Dashboard	4
17	2026-05-13	Add page and size params	High	f	Add Pagination	4
18	2026-05-14	Sort tasks by deadline	Medium	t	Add Sorting	4
19	2026-05-15	Filter by priority	High	f	Add Filtering	4
20	2026-05-16	Verify live API	Low	f	Test Deployment	4
21	2026-05-17	Create demo flow	High	f	Prepare Demo	5
22	2026-05-18	Rename endpoint methods	Medium	t	Clean Controllers	5
23	2026-05-19	Return tasks by user id	High	f	Fix User Tasks	5
24	2026-05-20	Verify BCrypt storage	Medium	t	Check Password Hashing	5
25	2026-05-21	Run all Postman requests	High	f	Final API Test	5
26	2026-05-22	Add global exceptions	High	f	Create Error Handler	6
27	2026-05-23	Return clean messages	Medium	f	Improve Responses	6
28	2026-05-24	Prepare frontend access	Low	t	Check CORS	6
29	2026-05-25	Count completed tasks	High	f	Create Analytics	6
30	2026-05-26	Fix spelling and format	Low	t	Review README	6
31	2026-05-27	Check repository methods	Medium	f	Optimize Queries	7
32	2026-05-28	Search tasks by title	Medium	f	Add Search	7
33	2026-05-29	Login with saved users	High	t	Test User Login	7
34	2026-05-30	Verify JWT expiration	High	f	Check Token Expiry	7
35	2026-05-31	Organize folders	Low	t	Clean Packages	7
36	2026-06-01	Add key code comments	Low	f	Write Comments	8
37	2026-06-02	Improve method names	Medium	t	Fix Naming	8
38	2026-06-03	Delete task by id	Medium	f	Test Delete API	8
39	2026-06-04	Update task status	High	f	Test Update API	8
40	2026-06-05	Save Postman results	Low	t	Create Screenshots	8
41	2026-06-06	Push final code	High	f	Prepare GitHub Repo	9
42	2026-06-07	Write GitHub summary	Medium	f	Add Project Description	9
43	2026-06-08	Remove secrets	High	t	Check Application Properties	9
44	2026-06-09	Add sample config	Medium	f	Create Env Example	9
45	2026-06-10	Remove test code	Low	t	Final Cleanup	9
46	2026-06-11	Record backend demo video	Medium	f	Record Demo	10
47	2026-06-12	Test deployed endpoints	High	f	Check Live APIs	10
49	2026-06-14	Finalize portfolio entry	Medium	t	Submit Project	10
50	2026-06-15	Decide future improvements	Low	f	Plan Next Feature	10
48	2026-06-13	Solve server error	Low	t	Fix Deployment Bug	10
\.


--
-- TOC entry 4815 (class 2606 OID 18107)
-- Name: new_users new_users_pkey; Type: CONSTRAINT; Schema: public; Owner: ?
--

ALTER TABLE ONLY public.new_users
    ADD CONSTRAINT new_users_pkey PRIMARY KEY (id);


--
-- TOC entry 4813 (class 2606 OID 18099)
-- Name: task task_pkey; Type: CONSTRAINT; Schema: public; Owner: ?
--

ALTER TABLE ONLY public.task
    ADD CONSTRAINT task_pkey PRIMARY KEY (id);


--
-- TOC entry 4816 (class 2606 OID 18108)
-- Name: task fkssdsb1oo9dg9w7qfa3l3mwkrf; Type: FK CONSTRAINT; Schema: public; Owner: ?
--

ALTER TABLE ONLY public.task
    ADD CONSTRAINT fkssdsb1oo9dg9w7qfa3l3mwkrf FOREIGN KEY (user_id) REFERENCES public.new_users(id);


-- Completed on 2026-04-27 02:28:44

--
-- PostgreSQL database dump complete
--

\unrestrict s01DECNSvNj4SCGr9aWLXskvXf0qC9PlzVBwkHNXSviRBmlQyYeWAWP2ZnKVqRE

