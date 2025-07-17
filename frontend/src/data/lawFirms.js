const lawFirms = [
    {
        id: 1,
        name: 'Justice & Partners LLP',
        description: 'Kancelaria świadcząca pełen zakres usług prawnych z wieloma specjalizacjami.',
        specialties: 'Prawo gospodarcze, procesy sądowe, własność intelektualna',
        contactInfo: 'contact@justicepartners.com | (555) 123-4567',
        website: 'https://justicepartners.com',
        foundingYear: 2005,
        attorneys: [
            { id: 1, name: 'Sarah Johnson', title: 'Starszy partner', specialty: 'Prawo gospodarcze' },
            { id: 2, name: 'Michael Chen', title: 'Partner', specialty: 'Własność intelektualna' }
        ]
    },
    {
        id: 2,
        name: 'Heritage Legal Group',
        description: 'Specjalizacja w prawie rodzinnym i planowaniu spadkowym.',
        specialties: 'Prawo rodzinne, planowanie spadkowe',
        contactInfo: 'info@heritagelegal.com | (555) 987-6543',
        website: 'https://heritagelegal.com',
        foundingYear: 1988,
        attorneys: [
            { id: 3, name: 'Robert Williams', title: 'Założyciel', specialty: 'Prawo rodzinne' }
        ]
    }
];

export default lawFirms;