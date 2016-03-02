package com.datastax.capitalone;

import java.util.Random;

public class DataGenerator {
	private String[] genders = {"F", "M"};
	private String[] femalefirstnames = {"MARY",	"PATRICIA",	"LINDA",	"BARBARA",	"ELIZABETH",	"JENNIFER",	"MARIA",	"SUSAN",	"MARGARET",	"DOROTHY",	"LISA",	"NANCY",	"KAREN",	"BETTY",	"HELEN",	"SANDRA",	"DONNA",	"CAROL",	"RUTH",	"SHARON",	"MICHELLE",	"LAURA",	"SARAH",	"KIMBERLY",	"DEBORAH",	"JESSICA",	"SHIRLEY",	"CYNTHIA",	"ANGELA",	"MELISSA",	"BRENDA",	"AMY",	"ANNA",	"REBECCA",	"VIRGINIA",	"KATHLEEN",	"PAMELA",	"MARTHA",	"DEBRA",	"AMANDA",	"STEPHANIE",	"CAROLYN",	"CHRISTINE",	"MARIE",	"JANET",	"CATHERINE",	"FRANCES",	"ANN",	"JOYCE",	"DIANE",	"ALICE",	"JULIE",	"HEATHER",	"TERESA",	"DORIS",	"GLORIA",	"EVELYN",	"JEAN",	"CHERYL",	"MILDRED",	"KATHERINE",	"JOAN",	"ASHLEY",	"JUDITH",	"ROSE",	"JANICE",	"KELLY",	"NICOLE",	"JUDY",	"CHRISTINA",	"KATHY",	"THERESA",	"BEVERLY",	"DENISE",	"TAMMY",	"IRENE",	"JANE",	"LORI",	"RACHEL",	"MARILYN",	"ANDREA",	"KATHRYN",	"LOUISE",	"SARA",	"ANNE",	"JACQUELINE",	"WANDA",	"BONNIE",	"JULIA",	"RUBY",	"LOIS",	"TINA",	"PHYLLIS",	"NORMA",	"PAULA",	"DIANA",	"ANNIE",	"LILLIAN",	"EMILY",	"ROBIN",	"PEGGY",	"CRYSTAL",	"GLADYS",	"RITA",	"DAWN",	"CONNIE",	"FLORENCE",	"TRACY",	"EDNA",	"TIFFANY",	"CARMEN",	"ROSA",	"CINDY",	"GRACE",	"WENDY",	"VICTORIA",	"EDITH",	"KIM",	"SHERRY",	"SYLVIA",	"JOSEPHINE",	"THELMA",	"SHANNON",	"SHEILA",	"ETHEL",	"ELLEN",	"ELAINE",	"MARJORIE",	"CARRIE",	"CHARLOTTE",	"MONICA",	"ESTHER",	"PAULINE",	"EMMA",	"JUANITA",	"ANITA",	"RHONDA",	"HAZEL",	"AMBER",	"EVA",	"DEBBIE",	"APRIL",	"LESLIE",	"CLARA",	"LUCILLE",	"JAMIE",	"JOANNE",	"ELEANOR",	"VALERIE",	"DANIELLE",	"MEGAN",	"ALICIA",	"SUZANNE",	"MICHELE",	"GAIL",	"BERTHA",	"DARLENE",	"VERONICA",	"JILL",	"ERIN",	"GERALDINE",	"LAUREN",	"CATHY",	"JOANN",	"LORRAINE",	"LYNN",	"SALLY",	"REGINA",	"ERICA",	"BEATRICE",	"DOLORES",	"BERNICE",	"AUDREY",	"YVONNE",	"ANNETTE",	"JUNE",	"SAMANTHA",	"MARION",	"DANA",	"STACY",	"ANA",	"RENEE",	"IDA",	"VIVIAN",	"ROBERTA",	"HOLLY",	"BRITTANY",	"MELANIE",	"LORETTA",	"YOLANDA",	"JEANETTE",	"LAURIE",	"KATIE",	"KRISTEN",	"VANESSA",	"ALMA",	"SUE",	"ELSIE",	"BETH",	"JEANNE",	"VICKI",	"CARLA",	"TARA",	"ROSEMARY",	"EILEEN",	"TERRI",	"GERTRUDE",	"LUCY",	"TONYA",	"ELLA",	"STACEY",	"WILMA",	"GINA",	"KRISTIN",	"JESSIE",	"NATALIE",	"AGNES",	"VERA",	"WILLIE",	"CHARLENE",	"BESSIE",	"DELORES",	"MELINDA",	"PEARL",	"ARLENE",	"MAUREEN",	"COLLEEN",	"ALLISON",	"TAMARA",	"JOY",	"GEORGIA",	"CONSTANCE",	"LILLIE",	"CLAUDIA",	"JACKIE",	"MARCIA",	"TANYA",	"NELLIE",	"MINNIE",	"MARLENE",	"HEIDI",	"GLENDA",	"LYDIA",	"VIOLA",	"COURTNEY",	"MARIAN",	"STELLA",	"CAROLINE",	"DORA",	"JO",	"VICKIE",	"MATTIE",	"TERRY",	"MAXINE",	"IRMA",	"MABEL",	"MARSHA",	"MYRTLE",	"LENA",	"CHRISTY",	"DEANNA",	"PATSY",	"HILDA",	"GWENDOLYN",	"JENNIE",	"NORA",	"MARGIE",	"NINA",	"CASSANDRA",	"LEAH",	"PENNY",	"KAY",	"PRISCILLA",	"NAOMI",	"CAROLE",	"BRANDY",	"OLGA",	"BILLIE",	"DIANNE",	"TRACEY",	"LEONA",	"JENNY",	"FELICIA",	"SONIA",	"MIRIAM",	"VELMA",	"BECKY",	"BOBBIE",	"VIOLET",	"KRISTINA",	"TONI",	"MISTY",	"MAE",	"SHELLY",	"DAISY",	"RAMONA",	"SHERRI",	"ERIKA",	"KATRINA",	"CLAIRE",	"LINDSEY",	"LINDSAY",	"GENEVA",	"GUADALUPE",	"BELINDA",	"MARGARITA",	"SHERYL",	"CORA",	"FAYE",	"ADA",	"NATASHA",	"SABRINA",	"ISABEL",	"MARGUERITE",	"HATTIE",	"HARRIET",	"MOLLY",	"CECILIA",	"KRISTI",	"BRANDI",	"BLANCHE",	"SANDY",	"ROSIE",	"JOANNA",	"IRIS",	"EUNICE",	"ANGIE",	"INEZ",	"LYNDA",	"MADELINE",	"AMELIA",	"ALBERTA",	"GENEVIEVE",	"MONIQUE",	"JODI",	"JANIE",	"MAGGIE",	"KAYLA",	"SONYA",	"JAN",	"LEE",	"KRISTINE",	"CANDACE",	"FANNIE",	"MARYANN",	"OPAL",	"ALISON",	"YVETTE",	"MELODY",	"LUZ",	"SUSIE",	"OLIVIA",	"FLORA",	"SHELLEY",	"KRISTY",	"MAMIE",	"LULA",	"LOLA",	"VERNA",	"BEULAH",	"ANTOINETTE",	"CANDICE",	"JUANA",	"JEANNETTE",	"PAM",	"KELLI",	"HANNAH",	"WHITNEY",	"BRIDGET",	"KARLA",	"CELIA",	"LATOYA",	"PATTY",	"SHELIA",	"GAYLE",	"DELLA",	"VICKY",	"LYNNE",	"SHERI",	"MARIANNE",	"KARA",	"JACQUELYN",	"ERMA",	"BLANCA",	"MYRA",	"LETICIA",	"PAT",	"KRISTA",	"ROXANNE",	"ANGELICA",	"JOHNNIE",	"ROBYN",	"FRANCIS",	"ADRIENNE",	"ROSALIE",	"ALEXANDRA",	"BROOKE",	"BETHANY",	"SADIE",	"BERNADETTE",	"TRACI",	"JODY",	"KENDRA",	"JASMINE",	"NICHOLE",	"RACHAEL",	"CHELSEA",	"MABLE",	"ERNESTINE",	"MURIEL",	"MARCELLA",	"ELENA",	"KRYSTAL",	"ANGELINA",	"NADINE",	"KARI",	"ESTELLE",	"DIANNA",	"PAULETTE",	"LORA",	"MONA",	"DOREEN",	"ROSEMARIE",	"ANGEL",	"DESIREE",	"ANTONIA",	"HOPE",	"GINGER",	"JANIS",	"BETSY",	"CHRISTIE",	"FREDA",	"MERCEDES",	"MEREDITH",	"LYNETTE",	"TERI",	"CRISTINA",	"EULA",	"LEIGH",	"MEGHAN",	"SOPHIA",	"ELOISE",	"ROCHELLE",	"GRETCHEN",	"CECELIA",	"RAQUEL",	"HENRIETTA",	"ALYSSA",	"JANA",	"KELLEY",	"GWEN",	"KERRY",	"JENNA",	"TRICIA",	"LAVERNE",	"OLIVE",	"ALEXIS",	"TASHA",	"SILVIA",	"ELVIRA",	"CASEY",	"DELIA",	"SOPHIE",	"KATE",	"PATTI",	"LORENA",	"KELLIE",	"SONJA",	"LILA",	"LANA",	"DARLA",	"MAY",	"MINDY",	"ESSIE",	"MANDY",	"LORENE",	"ELSA",	"JOSEFINA",	"JEANNIE",	"MIRANDA",	"DIXIE",	"LUCIA",	"MARTA",	"FAITH",	"LELA",	"JOHANNA",	"SHARI",	"CAMILLE",	"TAMI",	"SHAWNA",	"ELISA",	"EBONY",	"MELBA",	"ORA",	"NETTIE",	"TABITHA",	"OLLIE",	"JAIME",	"WINIFRED",	"KRISTIE"};
	private String[] malefirstnames = {"JAMES",	"JOHN",	"ROBERT",	"MICHAEL",	"WILLIAM",	"DAVID",	"RICHARD",	"CHARLES",	"JOSEPH",	"THOMAS",	"CHRISTOPHER",	"DANIEL",	"PAUL",	"MARK",	"DONALD",	"GEORGE",	"KENNETH",	"STEVEN",	"EDWARD",	"BRIAN",	"RONALD",	"ANTHONY",	"KEVIN",	"JASON",	"MATTHEW",	"GARY",	"TIMOTHY",	"JOSE",	"LARRY",	"JEFFREY",	"FRANK",	"SCOTT",	"ERIC",	"STEPHEN",	"ANDREW",	"RAYMOND",	"GREGORY",	"JOSHUA",	"JERRY",	"DENNIS",	"WALTER",	"PATRICK",	"PETER",	"HAROLD",	"DOUGLAS",	"HENRY",	"CARL",	"ARTHUR",	"RYAN",	"ROGER",	"JOE",	"JUAN",	"JACK",	"ALBERT",	"JONATHAN",	"JUSTIN",	"TERRY",	"GERALD",	"KEITH",	"SAMUEL",	"WILLIE",	"RALPH",	"LAWRENCE",	"NICHOLAS",	"ROY",	"BENJAMIN",	"BRUCE",	"BRANDON",	"ADAM",	"HARRY",	"FRED",	"WAYNE",	"BILLY",	"STEVE",	"LOUIS",	"JEREMY",	"AARON",	"RANDY",	"HOWARD",	"EUGENE",	"CARLOS",	"RUSSELL",	"BOBBY",	"VICTOR",	"MARTIN",	"ERNEST",	"PHILLIP",	"TODD",	"JESSE",	"CRAIG",	"ALAN",	"SHAWN",	"CLARENCE",	"SEAN",	"PHILIP",	"CHRIS",	"JOHNNY",	"EARL",	"JIMMY",	"ANTONIO",	"DANNY",	"BRYAN",	"TONY",	"LUIS",	"MIKE",	"STANLEY",	"LEONARD",	"NATHAN",	"DALE",	"MANUEL",	"RODNEY",	"CURTIS",	"NORMAN",	"ALLEN",	"MARVIN",	"VINCENT",	"GLENN",	"JEFFERY",	"TRAVIS",	"JEFF",	"CHAD",	"JACOB",	"LEE",	"MELVIN",	"ALFRED",	"KYLE",	"FRANCIS",	"BRADLEY",	"JESUS",	"HERBERT",	"FREDERICK",	"RAY",	"JOEL",	"EDWIN",	"DON",	"EDDIE",	"RICKY",	"TROY",	"RANDALL",	"BARRY",	"ALEXANDER",	"BERNARD",	"MARIO",	"LEROY",	"FRANCISCO",	"MARCUS",	"MICHEAL",	"THEODORE",	"CLIFFORD",	"MIGUEL",	"OSCAR",	"JAY",	"JIM",	"TOM",	"CALVIN",	"ALEX",	"JON",	"RONNIE",	"BILL",	"LLOYD",	"TOMMY",	"LEON",	"DEREK",	"WARREN",	"DARRELL",	"JEROME",	"FLOYD",	"LEO",	"ALVIN",	"TIM",	"WESLEY",	"GORDON",	"DEAN",	"GREG",	"JORGE",	"DUSTIN",	"PEDRO",	"DERRICK",	"DAN",	"LEWIS",	"ZACHARY",	"COREY",	"HERMAN",	"MAURICE",	"VERNON",	"ROBERTO",	"CLYDE",	"GLEN",	"HECTOR",	"SHANE",	"RICARDO",	"SAM",	"RICK",	"LESTER",	"BRENT",	"RAMON",	"CHARLIE",	"TYLER",	"GILBERT",	"GENE",	"MARC",	"REGINALD",	"RUBEN",	"BRETT",	"ANGEL",	"NATHANIEL",	"RAFAEL",	"LESLIE",	"EDGAR",	"MILTON",	"RAUL",	"BEN",	"CHESTER",	"CECIL",	"DUANE",	"FRANKLIN",	"ANDRE",	"ELMER",	"BRAD",	"GABRIEL",	"RON",	"MITCHELL",	"ROLAND",	"ARNOLD",	"HARVEY",	"JARED",	"ADRIAN",	"KARL",	"CORY",	"CLAUDE",	"ERIK",	"DARRYL",	"JAMIE",	"NEIL",	"JESSIE",	"CHRISTIAN",	"JAVIER",	"FERNANDO",	"CLINTON",	"TED",	"MATHEW",	"TYRONE",	"DARREN",	"LONNIE",	"LANCE",	"CODY",	"JULIO",	"KELLY",	"KURT",	"ALLAN",	"NELSON",	"GUY",	"CLAYTON",	"HUGH",	"MAX",	"DWAYNE",	"DWIGHT",	"ARMANDO",	"FELIX",	"JIMMIE",	"EVERETT",	"JORDAN",	"IAN",	"WALLACE",	"KEN",	"BOB",	"JAIME",	"CASEY",	"ALFREDO",	"ALBERTO",	"DAVE",	"IVAN",	"JOHNNIE",	"SIDNEY",	"BYRON",	"JULIAN",	"ISAAC",	"MORRIS",	"CLIFTON",	"WILLARD",	"DARYL",	"ROSS",	"VIRGIL",	"ANDY",	"MARSHALL",	"SALVADOR",	"PERRY",	"KIRK",	"SERGIO",	"MARION",	"TRACY",	"SETH",	"KENT",	"TERRANCE",	"RENE",	"EDUARDO",	"TERRENCE",	"ENRIQUE",	"FREDDIE",	"WADE"};
	private String[] lastnames = {"SMITH",	"JOHNSON",	"WILLIAMS",	"BROWN",	"JONES",	"MILLER",	"DAVIS",	"GARCIA",	"RODRIGUEZ",	"WILSON",	"MARTINEZ",	"ANDERSON",	"TAYLOR",	"THOMAS",	"HERNANDEZ",	"MOORE",	"MARTIN",	"JACKSON",	"THOMPSON",	"WHITE",	"LOPEZ",	"LEE",	"GONZALEZ",	"HARRIS",	"CLARK",	"LEWIS",	"ROBINSON",	"WALKER",	"PEREZ",	"HALL",	"YOUNG",	"ALLEN",	"SANCHEZ",	"WRIGHT",	"KING",	"SCOTT",	"GREEN",	"BAKER",	"ADAMS",	"NELSON",	"HILL",	"RAMIREZ",	"CAMPBELL",	"MITCHELL",	"ROBERTS",	"CARTER",	"PHILLIPS",	"EVANS",	"TURNER",	"TORRES",	"PARKER",	"COLLINS",	"EDWARDS",	"STEWART",	"FLORES",	"MORRIS",	"NGUYEN",	"MURPHY",	"RIVERA",	"COOK",	"ROGERS",	"MORGAN",	"PETERSON",	"COOPER",	"REED",	"BAILEY",	"BELL",	"GOMEZ",	"KELLY",	"HOWARD",	"WARD",	"COX",	"DIAZ",	"RICHARDSON",	"WOOD",	"WATSON",	"BROOKS",	"BENNETT",	"GRAY",	"JAMES",	"REYES",	"CRUZ",	"HUGHES",	"PRICE",	"MYERS",	"LONG",	"FOSTER",	"SANDERS",	"ROSS",	"MORALES",	"POWELL",	"SULLIVAN",	"RUSSELL",	"ORTIZ",	"JENKINS",	"GUTIERREZ",	"PERRY",	"BUTLER",	"BARNES",	"FISHER",	"HENDERSON",	"COLEMAN",	"SIMMONS",	"PATTERSON",	"JORDAN",	"REYNOLDS",	"HAMILTON",	"GRAHAM",	"KIM",	"GONZALES",	"ALEXANDER",	"RAMOS",	"WALLACE",	"GRIFFIN",	"WEST",	"COLE",	"HAYES",	"CHAVEZ",	"GIBSON",	"BRYANT",	"ELLIS",	"STEVENS",	"MURRAY",	"FORD",	"MARSHALL",	"OWENS",	"MCDONALD",	"HARRISON",	"RUIZ",	"KENNEDY",	"WELLS",	"ALVAREZ",	"WOODS",	"MENDOZA",	"CASTILLO",	"OLSON",	"WEBB",	"WASHINGTON",	"TUCKER",	"FREEMAN",	"BURNS",	"HENRY",	"VASQUEZ",	"SNYDER",	"SIMPSON",	"CRAWFORD",	"JIMENEZ",	"PORTER",	"MASON",	"SHAW",	"GORDON",	"WAGNER",	"HUNTER",	"ROMERO",	"HICKS",	"DIXON",	"HUNT",	"PALMER",	"ROBERTSON",	"BLACK",	"HOLMES",	"STONE",	"MEYER",	"BOYD",	"MILLS",	"WARREN",	"FOX",	"ROSE",	"RICE",	"MORENO",	"SCHMIDT",	"PATEL",	"FERGUSON",	"NICHOLS",	"HERRERA",	"MEDINA",	"RYAN",	"FERNANDEZ",	"WEAVER",	"DANIELS",	"STEPHENS",	"GARDNER",	"PAYNE",	"KELLEY",	"DUNN",	"PIERCE",	"ARNOLD",	"TRAN",	"SPENCER",	"PETERS",	"HAWKINS",	"GRANT",	"HANSEN",	"CASTRO",	"HOFFMAN",	"HART",	"ELLIOTT",	"CUNNINGHAM",	"KNIGHT",	"BRADLEY",	"CARROLL",	"HUDSON",	"DUNCAN",	"ARMSTRONG",	"BERRY",	"ANDREWS",	"JOHNSTON",	"RAY",	"LANE",	"RILEY",	"CARPENTER",	"PERKINS",	"AGUILAR",	"SILVA",	"RICHARDS",	"WILLIS",	"MATTHEWS",	"CHAPMAN",	"LAWRENCE",	"GARZA",	"VARGAS",	"WATKINS",	"WHEELER",	"LARSON",	"CARLSON",	"HARPER",	"GEORGE",	"GREENE",	"BURKE",	"GUZMAN",	"MORRISON",	"MUNOZ",	"JACOBS",	"OBRIEN",	"LAWSON",	"FRANKLIN",	"LYNCH",	"BISHOP",	"CARR",	"SALAZAR",	"AUSTIN",	"MENDEZ",	"GILBERT",	"JENSEN",	"WILLIAMSON",	"MONTGOMERY",	"HARVEY",	"OLIVER",	"HOWELL",	"DEAN",	"HANSON",	"WEBER",	"GARRETT",	"SIMS",	"BURTON",	"FULLER",	"SOTO",	"MCCOY",	"WELCH",	"CHEN",	"SCHULTZ",	"WALTERS",	"REID",	"FIELDS",	"WALSH",	"LITTLE",	"FOWLER",	"BOWMAN",	"DAVIDSON",	"MAY",	"DAY",	"SCHNEIDER",	"NEWMAN",	"BREWER",	"LUCAS",	"HOLLAND",	"WONG",	"BANKS",	"SANTOS",	"CURTIS",	"PEARSON",	"DELGADO",	"VALDEZ",	"PENA",	"RIOS",	"DOUGLAS",	"SANDOVAL",	"BARRETT",	"HOPKINS",	"KELLER",	"GUERRERO",	"STANLEY",	"BATES",	"ALVARADO",	"BECK",	"ORTEGA",	"WADE",	"ESTRADA",	"CONTRERAS",	"BARNETT",	"CALDWELL",	"SANTIAGO",	"LAMBERT",	"POWERS",	"CHAMBERS",	"NUNEZ",	"CRAIG",	"LEONARD",	"LOWE",	"RHODES",	"BYRD",	"GREGORY",	"SHELTON",	"FRAZIER",	"BECKER",	"MALDONADO",	"FLEMING",	"VEGA",	"SUTTON",	"COHEN",	"JENNINGS",	"PARKS",	"MCDANIEL",	"WATTS",	"BARKER",	"NORRIS",	"VAUGHN",	"VAZQUEZ",	"HOLT",	"SCHWARTZ",	"STEELE",	"BENSON",	"NEAL",	"DOMINGUEZ",	"HORTON",	"TERRY",	"WOLFE",	"HALE",	"LYONS",	"GRAVES",	"HAYNES",	"MILES",	"PARK",	"WARNER",	"PADILLA",	"BUSH",	"THORNTON",	"MCCARTHY",	"MANN",	"ZIMMERMAN",	"ERICKSON",	"FLETCHER",	"MCKINNEY",	"PAGE",	"DAWSON",	"JOSEPH",	"MARQUEZ",	"REEVES",	"KLEIN",	"ESPINOZA",	"BALDWIN",	"MORAN",	"LOVE",	"ROBBINS",	"HIGGINS",	"BALL",	"CORTEZ",	"LE",	"GRIFFITH",	"BOWEN",	"SHARP",	"CUMMINGS",	"RAMSEY",	"HARDY",	"SWANSON",	"BARBER",	"ACOSTA",	"LUNA",	"CHANDLER",	"BLAIR",	"DANIEL",	"CROSS",	"SIMON",	"DENNIS",	"OCONNOR",	"QUINN",	"GROSS",	"NAVARRO",	"MOSS",	"FITZGERALD",	"DOYLE",	"MCLAUGHLIN",	"ROJAS",	"RODGERS",	"STEVENSON",	"SINGH",	"YANG",	"FIGUEROA",	"HARMON",	"NEWTON",	"PAUL",	"MANNING",	"GARNER",	"MCGEE",	"REESE",	"FRANCIS",	"BURGESS",	"ADKINS",	"GOODMAN",	"CURRY",	"BRADY",	"CHRISTENSEN",	"POTTER",	"WALTON",	"GOODWIN",	"MULLINS",	"MOLINA",	"WEBSTER",	"FISCHER",	"CAMPOS",	"AVILA",	"SHERMAN",	"TODD",	"CHANG",	"BLAKE",	"MALONE",	"WOLF",	"HODGES",	"JUAREZ",	"GILL",	"FARMER",	"HINES",	"GALLAGHER",	"DURAN",	"HUBBARD",	"CANNON",	"MIRANDA",	"WANG",	"SAUNDERS",	"TATE",	"MACK",	"HAMMOND",	"CARRILLO",	"TOWNSEND",	"WISE",	"INGRAM",	"BARTON",	"MEJIA",	"AYALA",	"SCHROEDER",	"HAMPTON",	"ROWE",	"PARSONS",	"FRANK",	"WATERS",	"STRICKLAND",	"OSBORNE",	"MAXWELL",	"CHAN",	"DELEON",	"NORMAN",	"HARRINGTON",	"CASEY",	"PATTON",	"LOGAN",	"BOWERS",	"MUELLER",	"GLOVER",	"FLOYD",	"HARTMAN",	"BUCHANAN",	"COBB",	"FRENCH",	"KRAMER",	"MCCORMICK",	"CLARKE",	"TYLER",	"GIBBS",	"MOODY",	"CONNER",	"SPARKS",	"MCGUIRE",	"LEON",	"BAUER",	"NORTON",	"POPE",	"FLYNN",	"HOGAN",	"ROBLES",	"SALINAS",	"YATES",	"LINDSEY",	"LLOYD",	"MARSH",	"MCBRIDE",	"OWEN",	"SOLIS",	"PHAM",	"LANG",	"PRATT",	"LARA",	"BROCK",	"BALLARD",	"TRUJILLO",	"SHAFFER",	"DRAKE",	"ROMAN",	"AGUIRRE",	"MORTON",	"STOKES",	"LAMB",	"PACHECO",	"PATRICK",	"COCHRAN",	"SHEPHERD",	"CAIN",	"BURNETT",	"HESS",	"LI",	"CERVANTES",	"OLSEN",	"BRIGGS",	"OCHOA",	"CABRERA",	"VELASQUEZ",	"MONTOYA",	"ROTH",	"MEYERS",	"CARDENAS",	"FUENTES",	"WEISS",	"HOOVER",	"WILKINS",	"NICHOLSON",	"UNDERWOOD",	"SHORT",	"CARSON",	"MORROW",	"COLON",	"HOLLOWAY",	"SUMMERS",	"BRYAN",	"PETERSEN",	"MCKENZIE",	"SERRANO",	"WILCOX",	"CAREY",	"CLAYTON",	"POOLE",	"CALDERON",	"GALLEGOS",	"GREER",	"RIVAS",	"GUERRA",	"DECKER",	"COLLIER",	"WALL",	"WHITAKER",	"BASS",	"FLOWERS",	"DAVENPORT",	"CONLEY",	"HOUSTON",	"HUFF",	"COPELAND",	"HOOD",	"MONROE",	"MASSEY",	"ROBERSON",	"COMBS",	"FRANCO",	"LARSEN",	"PITTMAN",	"RANDALL",	"SKINNER",	"WILKINSON",	"KIRBY",	"CAMERON",	"BRIDGES",	"ANTHONY",	"RICHARD",	"KIRK",	"BRUCE",	"SINGLETON",	"MATHIS",	"BRADFORD",	"BOONE",	"ABBOTT",	"CHARLES",	"ALLISON",	"SWEENEY",	"ATKINSON",	"HORN",	"JEFFERSON",	"ROSALES",	"YORK",	"CHRISTIAN",	"PHELPS",	"FARRELL",	"CASTANEDA",	"NASH",	"DICKERSON",	"BOND",	"WYATT",	"FOLEY",	"CHASE",	"GATES",	"VINCENT",	"MATHEWS",	"HODGE",	"GARRISON",	"TREVINO",	"VILLARREAL",	"HEATH",	"DALTON",	"VALENCIA",	"CALLAHAN",	"HENSLEY",	"ATKINS",	"HUFFMAN",	"ROY",	"BOYER",	"SHIELDS",	"LIN",	"HANCOCK",	"GRIMES",	"GLENN",	"CLINE",	"DELACRUZ",	"CAMACHO",	"DILLON",	"PARRISH",	"ONEILL",	"MELTON",	"BOOTH",	"KANE",	"BERG",	"HARRELL",	"PITTS",	"SAVAGE",	"WIGGINS",	"BRENNAN",	"SALAS",	"MARKS",	"RUSSO",	"SAWYER",	"BAXTER",	"GOLDEN",	"HUTCHINSON",	"LIU",	"WALTER",	"MCDOWELL",	"WILEY",	"RICH",	"HUMPHREY",	"JOHNS",	"KOCH",	"SUAREZ",	"HOBBS",	"BEARD",	"GILMORE",	"IBARRA",	"KEITH",	"MACIAS",	"KHAN",	"ANDRADE",	"WARE",	"STEPHENSON",	"HENSON",	"WILKERSON",	"DYER",	"MCCLURE",	"BLACKWELL",	"MERCADO",	"TANNER",	"EATON",	"CLAY",	"BARRON",	"BEASLEY",	"ONEAL",	"PRESTON",	"SMALL",	"WU",	"ZAMORA",	"MACDONALD",	"VANCE",	"SNOW",	"MCCLAIN",	"STAFFORD",	"OROZCO",	"BARRY",	"ENGLISH",	"SHANNON",	"KLINE",	"JACOBSON",	"WOODARD",	"HUANG",	"KEMP",	"MOSLEY",	"PRINCE",	"MERRITT",	"HURST",	"VILLANUEVA",	"ROACH",	"NOLAN",	"LAM",	"YODER",	"MCCULLOUGH",	"LESTER",	"SANTANA",	"VALENZUELA",	"WINTERS",	"BARRERA",	"LEACH",	"ORR",	"BERGER",	"MCKEE",	"STRONG",	"CONWAY",	"STEIN",	"WHITEHEAD",	"BULLOCK",	"ESCOBAR",	"KNOX",	"MEADOWS",	"SOLOMON",	"VELEZ",	"ODONNELL",	"KERR",	"STOUT",	"BLANKENSHIP",	"BROWNING",	"KENT",	"LOZANO",	"BARTLETT",	"PRUITT",	"BUCK",	"BARR",	"GAINES",	"DURHAM",	"GENTRY",	"MCINTYRE",	"SLOAN",	"MELENDEZ",	"ROCHA",	"HERMAN",	"SEXTON",	"MOON",	"HENDRICKS",	"RANGEL",	"STARK",	"LOWERY",	"HARDIN",	"HULL",	"SELLERS",	"ELLISON",	"CALHOUN",	"GILLESPIE",	"MORA",	"KNAPP",	"MCCALL",	"MORSE",	"DORSEY",	"WEEKS",	"NIELSEN",	"LIVINGSTON",	"LEBLANC",	"MCLEAN",	"BRADSHAW",	"GLASS",	"MIDDLETON",	"BUCKLEY",	"SCHAEFER",	"FROST",	"HOWE",	"HOUSE",	"MCINTOSH",	"HO",	"PENNINGTON",	"REILLY",	"HEBERT",	"MCFARLAND",	"HICKMAN",	"NOBLE",	"SPEARS",	"CONRAD",	"ARIAS",	"GALVAN",	"VELAZQUEZ",	"HUYNH",	"FREDERICK",	"RANDOLPH",	"CANTU",	"FITZPATRICK",	"MAHONEY",	"PECK",	"VILLA",	"MICHAEL",	"DONOVAN",	"MCCONNELL",	"WALLS",	"BOYLE",	"MAYER",	"ZUNIGA",	"GILES",	"PINEDA",	"PACE",	"HURLEY",	"MAYS",	"MCMILLAN",	"CROSBY",	"AYERS",	"CASE",	"BENTLEY",	"SHEPARD",	"EVERETT",	"PUGH",	"DAVID",	"MCMAHON",	"DUNLAP",	"BENDER",	"HAHN",	"HARDING",	"ACEVEDO",	"RAYMOND",	"BLACKBURN",	"DUFFY",	"LANDRY",	"DOUGHERTY",	"BAUTISTA",	"SHAH",	"POTTS",	"ARROYO",	"VALENTINE",	"MEZA",	"GOULD",	"VAUGHAN",	"FRY",	"RUSH",	"AVERY",	"HERRING",	"DODSON",	"CLEMENTS",	"SAMPSON",	"TAPIA",	"BEAN",	"LYNN",	"CRANE",	"FARLEY",	"CISNEROS",	"BENTON",	"ASHLEY",	"MCKAY",	"FINLEY",	"BEST",	"BLEVINS",	"FRIEDMAN",	"MOSES",	"SOSA",	"BLANCHARD",	"HUBER",	"FRYE",	"KRUEGER",	"BERNARD",	"ROSARIO",	"RUBIO",	"MULLEN",	"BENJAMIN",	"HALEY",	"CHUNG",	"MOYER",	"CHOI",	"HORNE",	"YU",	"WOODWARD",	"ALI",	"NIXON",	"HAYDEN",	"RIVERS",	"ESTES",	"MCCARTY",	"RICHMOND",	"STUART",	"MAYNARD",	"BRANDT",	"OCONNELL",	"HANNA",	"SANFORD",	"SHEPPARD",	"CHURCH",	"BURCH",	"LEVY",	"RASMUSSEN",	"COFFEY",	"PONCE",	"FAULKNER",	"DONALDSON",	"SCHMITT",	"NOVAK",	"COSTA",	"MONTES",	"BOOKER",	"CORDOVA",	"WALLER",	"ARELLANO",	"MADDOX",	"MATA",	"BONILLA",	"STANTON",	"COMPTON",	"KAUFMAN",	"DUDLEY",	"MCPHERSON",	"BELTRAN",	"DICKSON",	"MCCANN",	"VILLEGAS",	"PROCTOR",	"HESTER",	"CANTRELL",	"DAUGHERTY",	"CHERRY",	"BRAY",	"DAVILA",	"ROWLAND",	"LEVINE",	"MADDEN",	"SPENCE",	"GOOD",	"IRWIN",	"WERNER",	"KRAUSE",	"PETTY",	"WHITNEY",	"BAIRD",	"HOOPER",	"POLLARD",	"ZAVALA",	"JARVIS",	"HOLDEN",	"HAAS",	"HENDRIX",	"MCGRATH",	"BIRD",	"LUCERO",	"TERRELL",	"RIGGS",	"JOYCE",	"MERCER",	"ROLLINS",	"GALLOWAY",	"DUKE",	"ODOM",	"ANDERSEN",	"DOWNS",	"HATFIELD",	"BENITEZ",	"ARCHER",	"HUERTA",	"TRAVIS",	"MCNEIL",	"HINTON",	"ZHANG",	"HAYS",	"MAYO",	"FRITZ",	"BRANCH",	"MOONEY",	"EWING",	"RITTER",	"ESPARZA",	"FREY",	"BRAUN",	"GAY",	"RIDDLE",	"HANEY",	"KAISER",	"HOLDER",	"CHANEY",	"MCKNIGHT",	"GAMBLE",	"VANG",	"COOLEY",	"CARNEY",	"COWAN",	"FORBES",	"FERRELL",	"DAVIES",	"BARAJAS",	"SHEA",	"OSBORN",	"BRIGHT",	"CUEVAS",	"BOLTON",	"MURILLO",	"LUTZ",	"DUARTE",	"KIDD",	"KEY",	"COOKE"};
	private String[] suffix = {"MARKET",	"ANTIQUES",	"SHOP",	"LLC",	"INC",	"CORPORATION",	"COMPANY",	"COUNSELING",	"SERVICES",	"MD",	"STYLIST",	"SALON",	"THERAPY",	"CLUB",	"CREATIONS",	"CENTER",	"UNLIMITED",	"CAPITAL",	"PARTNERS",	"ASSOCIATES",	"PC",	"CIRCLE",	"GROUP",	"CARE",	"HAIR",	"FAMILY",	"SOLUTIONS",	"DENTAL",	"FOUNDATION",	"SPA",	"CAFE",	"REPAIR",	"PLLC",	"DESIGN",	"POOL",	"FOOD",	"HOME",	"AIR",	"AMERICAN",	"MEDICAL",	"BAR",	"WEST",	"CENTRAL",	"ENTERPRISES",	"HEALTH",	"BEAUTY",	"SUPPLY",	"PHOTOGRAPHY",	"GRILL",	"PIZZA",	"OFFICE",	"STUDIO",	"TRANSPORTATION",	"TAXI",	"SCHOOL",	"ASSOCIATION",	"CHURCH",	"DESIGNS",	"SOUTHWEST",	"RESTAURANT",	"MEDIA",	"CLEANERS",	"SALES",	"ASSOCIATES",	"STORE",	"BARBER",	"LIFE",	"HOUSE",	"NAILS",	"CAB",	"BOX",	"GLASS",	"NORTH",	"MARKETING",	"SYSTEMS",	"CHIROPRACTIC",	"CLEANING",	"PLUMBING",	"SPORTS",	"CUSTOM",	"PRODUCTS",	"TAX",	"PRO",	"MASSAGE",	"SMOKE",	"EXPRESS",	"DELI",	"WORLD",	"AUTOMOTIVE",	"INTERNATIONAL",	"CAR",	"ACADEMY",	"MOBILE",	"TREE",	"DOLLAR",	"CITY",	"CELLULAR",	"METRO",	"ELECTRIC",	"FITNESS",	"BODY",	"MOUNTAIN",	"FIRST",	"STORAGE",	"CONSULTING",	"PARADISE",	"TACOS",	"EQUIPMENT",	"TRUCKS",	"CLINIC",	"INSURANCE",	"IT",	"PRODUCTIONS",	"DAY",	"MECHANICAL",	"WIRELESS",	"TIRE",	"BUSINESS",	"PERFORMANCE",	"PHONES",	"GARAGE",	"FURNITURE",	"USA",	"CANYON",	"BOUTIQUE",	"WELLNESS",	"WESTERN",	"SNACKS",	"CONSTRUCTION",	"INSTITUTE",	"FIRM",	"SOCIETY",	"STONE",	"KING",	"GOLF",	"SKIN",	"HEATING",	"COOLING",	"VIDEO",	"TECH",	"OFFICES",	"DIRECT",	"JEWELRY",	"COMMUNICATIONS",	"MUSIC",	"ENTERTAINMENT",	"ART",	"DISCOUNT",	"SUPERSTORE",	"MANAGEMENT",	"COFFEE",	"ARCADE",	"RESCUE",	"PRINTING",	"MEDICINE",	"CATERING",	"INN",	"HUT",	"BELL",	"COMPUTERS",	"TRAINING",	"LIVING",	"PLUS",	"CARPET",	"ALLIANCE",	"LANDSCAPING",	"EDUCATION",	"CONTROL",	"TOWING",	"PLACE",	"PREMIER",	"CLOTHING",	"ACCOUNTING",	"FASHION",	"MALL",	"FINANCIAL",	"BARBER",	"TEAM",	"DANCE",	"OPTICAL",	"CONSULTANTS",	"MINISTRIES",	"MOVERS",	"POWER",	"BURGER",	"BUFFET",	"CONCEPTS",	"ROOFING",	"VISION",	"LEAGUE",	"ELITE",	"DONUTS",	"LIMOUSINE",	"REFRIGERATION",	"HOSPITAL",	"BBQ",	"PAINTING",	"PEDIATRICS",	"TATTOO",	"SUPPLIES",	"WHOLESALE",	"DEVELOPMENT",	"GARDEN",	"METAL",	"TRAVEL",	"ENERGY",	"RENTALS",	"VALET",	"SURGICAL",	"FLOORING",	"GALLERY",	"IMAGING",	"SUPERIOR",	"SOLAR"};
	private String[] street = {"MAIN",	"1ST",	"2ND",	"3RD",	"4TH",	"5TH",	"6TH",	"7TH",	"8TH",	"9TH",	"10TH",	"11TH",	"12TH",	"13TH",	"14TH",	"15TH",	"16TH",	"17TH",	"18TH",	"19TH",	"20TH",	"21ST",	"22ND",	"23RD",	"24TH",	"25TH",	"26TH",	"27TH",	"28TH",	"29TH",	"30TH",	"31ST",	"32ND",	"33RD",	"34TH",	"35TH",	"36TH",	"37TH",	"38TH",	"39TH",	"40TH",	"41ST",	"42ND",	"43RD",	"44TH",	"45TH",	"46TH",	"47TH",	"48TH",	"49TH",	"50TH",	"51ST",	"52ND",	"53RD",	"54TH",	"55TH",	"56TH",	"57TH",	"58TH",	"59TH",	"60TH",	"61ST",	"62ND",	"63RD",	"64TH",	"65TH",	"66TH",	"67TH",	"68TH",	"69TH",	"70TH",	"71ST",	"72ND",	"73RD",	"74TH",	"75TH",	"76TH",	"77TH",	"78TH",	"79TH",	"80TH",	"81ST",	"82ND",	"83RD",	"84TH",	"85TH",	"86TH",	"87TH",	"88TH",	"89TH",	"90TH",	"91ST",	"92ND",	"93RD",	"94TH",	"95TH",	"96TH",	"97TH",	"98TH",	"99TH",	"ASH",	"ASPEN",	"BEECH",	"BIRCH",	"CHERRY",	"ELM",	"FIR",	"CHESTNUT",	"COTTONWOOD",	"HAWTHORN",	"HEMLOCK",	"HICKORY",	"LOCUST",	"OAK",	"PINE",	"SPRUCE",	"WALNUT",	"WILLOW",	"WASHINGTON",	"ADAMS",	"JEFFERSON",	"MADISON",	"MONROE",	"JACKSON",	"VAN BUREN",	"HARRISON",	"TYLER",	"POLK",	"TAYLOR",	"FILLMORE",	"PIERCE",	"BUCHANAN",	"LINCOLN",	"JOHNSON",	"GRANT",	"HAYES",	"GARFIELD",	"ARTHUR",	"CLEVELAND",	"MCKINLEY",	"ROOSEVELT",	"TAFT",	"WILSON",	"HARDING",	"COOLIDGE",	"HOOVER",	"TRUMAN",	"EISENHOWER",	"KENNEDY",	"NIXON",	"FORD",	"CARTER",	"REAGAN",	"ALABAMA ",	"ALASKA ",	"ARIZONA ",	"ARKANSAS ",	"CALIFORNIA ",	"COLORADO ",	"CONNECTICUT ",	"DELAWARE ",	"FLORIDA ",	"GEORGIA ",	"HAWAII ",	"IDAHO ",	"ILLINOIS",	"INDIANA",	"IOWA ",	"KANSAS ",	"KENTUCKY ",	"LOUISIANA ",	"MAINE ",	"MARYLAND ",	"MASSACHUSETTS ",	"MICHIGAN ",	"MINNESOTA ",	"MISSISSIPPI ",	"MISSOURI ",	"MONTANA ",	"NEBRASKA",	"NEVADA ",	"NEW HAMPSHIRE ",	"NEW JERSEY ",	"NEW MEXICO ",	"NEW YORK ",	"NORTH CAROLINA ",	"NORTH DAKOTA ",	"OHIO ",	"OKLAHOMA ",	"OREGON ",	"PENNSYLVANIA",	"RHODE ISLAND ",	"SOUTH CAROLINA ",	"SOUTH DAKOTA ",	"TENNESSEE ",	"TEXAS ",	"UTAH ",	"VERMONT ",	"VIRGINIA ",	"WASHINGTON ",	"WEST VIRGINIA ",	"WISCONSIN ",	"WYOMING"};
	private String[] streettype = {"ST",	"PL",	"AVE",	"CT",	"BLVD",	"PKWY",	"HWY",	"RTE",	"RD"};
	private String[] streetdir = {"N",	"S",	"E",	"W",	"NE",	"SE",	"NW",	"SW"};
	private String[] line2 = {"UNIT", "STE", "APT", "BLDG", "FLOOR"};
	
	public String getGender(){
		Random r = new Random();
		return genders[r.nextInt(2)];
	}
	
	public String getLine2(){
		Random r = new Random();
		return line2[r.nextInt(5)];		
	}
	
	public String getSuffix(){
		Random r = new Random();
		return suffix[r.nextInt(214)];
	}
	
	public String getStreet(){
		Random r = new Random();
		return street[r.nextInt(203)];
	}
	
	public String getStreetType(){
		Random r = new Random();
		return streettype[r.nextInt(9)];
	}
	
	public String getStreetDir(){
		Random r = new Random();
		return streetdir[r.nextInt(8)];
	}
	
	public String getAddressLine1(){
		Random r = new Random();
		return r.nextInt(10000) + " " + this.getStreetDir() + " " + this.getStreet() + " " + this.getStreetType();
	}
	
	public String getAddressLine2(){
		Random r = new Random();

		//Populate line2 once out of every 8 records
		int populated = r.nextInt(8);
		
		if (populated == 1){
			return this.getLine2() + " " + r.nextInt(100);
		}
		else{
			return "";
		}
	}
	
	public String getCountry(){
		return "UNITED STATES";
	}
	
	public String getPhoneNumber(){
		Random r = new Random();
		return "(" + (r.nextInt(900)+100) + ")" + (r.nextInt(900)+100) + "-" + (r.nextInt(9000)+1000);
	}
	
	public String getMerchantName(){
		Random r = new Random();
		String name = "";
		int type = r.nextInt(3);
		
		switch(type){
		case 0: 
			name = this.getFirstName();
			break;
		case 1:
			name = this.getLastName();
			break;
		case 2:
			name = this.getFirstName() + " " + this.getLastName();
		}
		
		name = name + " " + this.getSuffix();
		
		return name;
	}
	
	public String getFirstName(String gender){
		String firstname = "";
		switch (gender){
		case "M" : firstname = getMaleFirstName();
		case "F" : firstname = getFemaleFirstName();
		}
		return firstname;
	}
	
	public String getFirstName(){
		return getFirstName(getGender());
	}
	
	public String getLastName(){
		Random r = new Random();
		return lastnames[r.nextInt(1000)];
	}
	
	private String getMaleFirstName(){
		Random r = new Random();
		return malefirstnames[r.nextInt(300)];
	}
	
	private String getFemaleFirstName(){
		Random r = new Random();
		return femalefirstnames[r.nextInt(500)];
	}

	
}