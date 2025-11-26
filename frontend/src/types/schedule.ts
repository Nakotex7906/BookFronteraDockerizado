// Define los bloques de horario
export type TimeSlot = {
    id: string;
    label: string;
    start: string;
    end: string;
};

// Define la disponibilidad de una celda
export interface Availability {
    roomId: string;
    slotId: string;
    available: boolean;
}

// Objeto principal que devuelve la API de disponibilidad
export type DailyAvailabilityResponse = {
    rooms: import('../types/room').Room[];
    slots: TimeSlot[];
    availability: Availability[];
};

// --- AQUÍ ESTABA EL ERROR ---
// Debes asegurarte de que tenga startAt y endAt
export type ReservationRequest = {
    roomId: string;
    startAt: string;        // <--- Asegúrate que esto esté así
    endAt: string;          // <--- Y esto también
    addToGoogleCalendar: boolean;
};

export type ReservationResponse = {
    id: string;
};

// Tipos para el usuario
export type UserDto = {
    id: number;
    email: string;
    nombre: string;
    rol: 'STUDENT' | 'ADMIN';
};

// Tipos para la sala (simplificado para reservas)
export type RoomDto = {
    id: number;
    name: string;
    capacity: number;
};

// Detalle completo de una reserva
export type ReservationDetail = {
    id: number;
    startAt: string;
    endAt: string;
    room: RoomDto;
    user: UserDto;
};

// Respuesta de "Mis Reservas"
export type MyReservationsResponse = {
    current: ReservationDetail | null;
    future: ReservationDetail[];
    past: ReservationDetail[];
};