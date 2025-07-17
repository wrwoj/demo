const sampleQuestions = [
    {
        id: 101,
        title: "Pytanie o rozwód",
        content: "Jakie są procedury rozwodowe w przypadku braku zgody obu stron?",
        isQuestion: true,
        datePublished: "2024-06-15",
        lawFirm: { id: 1, name: "Kancelaria Prawna 'Lex'" }
    },
    {
        id: 102,
        title: "Umowa najmu",
        content: "Czy umowa najmu na czas nieokreślony może być wypowiedziana w każdym momencie?",
        isQuestion: true,
        datePublished: "2024-06-20",
        lawFirm: { id: 1, name: "Kancelaria Prawna 'Lex'" }
    },
    {
        id: 103,
        title: "Spadek po zmarłym",
        content: "Jakie dokumenty są potrzebne do przeprowadzenia postępowania spadkowego?",
        isQuestion: true,
        datePublished: "2024-06-25",
        lawFirm: { id: 2, name: "Adwokaci i Partnerzy" }
    },
    {
        id: 104,
        title: "Pytanie o alimenty",
        content: "Czy wysokość alimentów może być zmieniona po orzeczeniu sądu?",
        isQuestion: true,
        datePublished: "2024-07-01",
        answerContent: "Tak, wysokość alimentów może być zmieniona w przypadku istotnej zmiany stosunków.",
        answerDate: "2024-07-05",
        answeredBy: { id: 1, name: "Jan Kowalski" },
        lawFirm: { id: 1, name: "Kancelaria Prawna 'Lex'" }
    }
];

export default sampleQuestions;