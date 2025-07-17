const sampleAdviceList = [
    {
        id: 1,
        title: 'Prawa najemcy: Wymogi dotyczące zawiadomienia o wejściu',
        description: 'Obowiązki właściciela nieruchomości w zakresie wejścia na wynajmowaną posesję',
        category: 'Mieszkalnictwo',
        content: 'Właściciele muszą poinformować najemców z odpowiednim wyprzedzeniem przed wejściem do wynajmowanego lokalu...',
        legalBasis: 'Sekcja 85 Ustawy o najmie mieszkaniowym z 2010 r.',
        relatedLaws: 'Ustawa o najmie mieszkaniowym 2010, Ustawa o prawie rzeczowym 1974',
        contactInfo: 'Infolinia dla najemców: 1800 123 456',
        author: 'Jane Smith, radca prawny',
        datePublished: '2024-01-15',
        lastUpdated: '2024-05-20',
        views: 2450,
        featured: true,
        difficultyLevel: 'Początkujący',
        isQuestion: false,
        lawFirmId: 1,
        lawFirm: {
            id: 1,
            name: 'Justice & Partners LLP',
            specialties: 'Prawo gospodarcze, procesy sądowe, własność intelektualna'
        }
    },
    {
        id: 2,
        title: 'Podstawy ochrony praw autorskich',
        description: 'Podstawowe zasady ochrony praw autorskich',
        category: 'Własność intelektualna',
        content: 'Prawa autorskie automatycznie chronią oryginalne dzieła autorstwa...',
        legalBasis: 'Ustawa o prawach autorskich z 1968 r. (Cth)',
        relatedLaws: 'Ustawa o prawach autorskich 1968, Nowelizacja ustawy o własności intelektualnej 2015',
        contactInfo: 'IP Australia: 1300 651 010',
        author: 'Robert Johnson, prawnik',
        datePublished: '2023-11-05',
        lastUpdated: '2024-03-15',
        views: 3120,
        featured: true,
        difficultyLevel: 'Początkujący',
        isQuestion: false,
        lawFirmId: 1,
        lawFirm: {
            id: 1,
            name: 'Justice & Partners LLP',
            specialties: 'Prawo gospodarcze, procesy sądowe, własność intelektualna'
        }
    },
    {
        id: 3,
        title: 'Procedury sądu ds. drobnych roszczeń',
        description: 'Jak poruszać się po procedurze w sądzie ds. drobnych roszczeń',
        category: 'Prawo cywilne',
        content: 'Sądy ds. drobnych roszczeń zapewniają dostępne forum do rozwiązywania drobnych sporów...',
        legalBasis: 'Sekcja 379 Zjednoliconych zasad procedury cywilnej 2005',
        relatedLaws: 'Ustawa o procedurze cywilnej 2005, Ustawa o sądzie rejonowym 2007',
        contactInfo: 'Poradnia ds. drobnych roszczeń: 1800 789 123',
        author: 'Amanda Chen, LLM',
        datePublished: '2024-02-28',
        lastUpdated: '2024-06-10',
        views: 1780,
        featured: false,
        difficultyLevel: 'Średniozaawansowany',
        isQuestion: false,
        lawFirmId: 2,
        lawFirm: {
            id: 2,
            name: 'Heritage Legal Group',
            specialties: 'Prawo rodzinne, planowanie spadkowe'
        }
    },
    // Sample questions
    {
        id: 4,
        title: 'Pytanie dotyczące umów najmu',
        content: 'O ile procent właściciel może podnieść czynsz każdego roku?',
        author: 'Anonimowy użytkownik',
        datePublished: '2024-07-16',
        lastUpdated: '2024-07-16',
        isQuestion: true,
        lawFirmId: 1,
        lawFirm: {
            id: 1,
            name: 'Justice & Partners LLP',
            specialties: 'Prawo gospodarcze, procesy sądowe, własność intelektualna'
        }
    },
    {
        id: 5,
        title: 'Pytanie dotyczące spadków',
        content: 'Jakie dokumenty są potrzebne do odziedziczenia majątku?',
        author: 'Anonimowy użytkownik',
        datePublished: '2024-07-15',
        lastUpdated: '2024-07-15',
        isQuestion: true,
        lawFirmId: 2,
        lawFirm: {
            id: 2,
            name: 'Heritage Legal Group',
            specialties: 'Prawo rodzinne, planowanie spadkowe'
        }
    }
];

export default sampleAdviceList;