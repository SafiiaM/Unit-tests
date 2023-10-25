package seminars.fourth.hotel;

public class HotelService {
    public boolean isRoomAvailable(int roomId) {
        // Код, который проверяет, доступен ли номер.
        // В реальной ситуации здесь мы бы сделали запрос к базе данных или другому сервису,
        // чтобы проверить доступность комнаты.
        // Но для простоты этого примера, давайте просто симулируем это поведение:
        // предположим, что комнаты с четными номерами доступны, а с нечетными - нет.
        return roomId % 2 == 0;
    }
}
