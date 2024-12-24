import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.pet.entities.RoomEntity;
import org.pet.enums.RoomType;
import org.pet.repositories.RoomRepository;
import org.pet.services.RoomServiceImpl;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RoomServiceTest {
    @InjectMocks
    private RoomServiceImpl roomService;

    @Mock
    private RoomRepository roomRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAvailableSingleRoomsSortedByPriceAsc() {
        RoomEntity room = new RoomEntity();
        room.setRoomType(RoomType.SINGLE);
        room.setPrice(100.0);

        when(roomRepository.findByHotelIdAndAvailableTrueAndRoomTypeOrderByPriceAsc(1L, RoomType.SINGLE))
                .thenReturn(Collections.singletonList(room));

        List<RoomEntity> availableRooms = roomService.getAvailableSingleRoomsSortedByPriceAsc(1L);
        assertThat(availableRooms).hasSize(1);
        assertThat(availableRooms.get(0).getRoomType()).isEqualTo(RoomType.SINGLE);
        assertThat(availableRooms.get(0).getPrice()).isEqualTo(100.0);
    }
}
