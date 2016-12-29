/**
 * Created by daijiajia on 2016/12/16.
 */
public class XXXControllerIntegrationTest extends BaseIntegrationTest {
    @Autowired
    private XXXController xxxController;

    @Autowired
    private XXXRepository xxxRepository;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(xxxController).build();
    }

    @Test
    public void should_get_xxxs_by_book_xxx() throws Exception {
        xxxRepository.save(new XXX("123456", "This is a integ test"));

        mockMvc.perform(get(format("/xxx/%s/yyys", vvv)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].uuid").value("123456"))
                .andExpect(jsonPath("$[0].content").value("This is a integ test"));
    }
}
