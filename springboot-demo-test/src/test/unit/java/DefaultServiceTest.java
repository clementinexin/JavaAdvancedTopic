import org.junit.Before;
import org.junit.Test;

/**
 * Created by daijiajia on 2016/12/16.
 */
public class DefaultServiceTest {

    @InjectMocks
    private DefaultXxxService xxxService;

    @Mock
    private XxxRepository xxxRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_retrieve_xxxs_by_yyy_uuid() {
        String yyyUuid = "book123456";
        List<Xxx> expectedXxxs = asList(new Xxx(), new Xxx());
        when(xxxRepository.findByYyy(yyyUuid)).thenReturn(expectedXxxs);

        Iterable<Xxx> xxxs = xxxService.retrieveXxxs(yyyUuid);

        assertThat(xxxs, is(expectedXxxs));
    }
}
