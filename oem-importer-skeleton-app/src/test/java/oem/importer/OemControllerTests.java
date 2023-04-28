package oem.importer;

import oem.importer.domain.File;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OemControllerTests {
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    void importFile_validCsv_returns201() {
        File myCsvFile = new File("csv");

        ResponseEntity<String> result = template.postForEntity(base.toString() + "/import", myCsvFile, String.class);

        assertThat(result.getBody()).isEqualTo("IMPORT SUCCESS");
        assertThat(result.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    void importFile_validXml_returns201() {
        File myXmlFile = new File("xml");

        ResponseEntity<String> result = template.postForEntity(base.toString() + "/import", myXmlFile, String.class);

        assertThat(result.getBody()).isEqualTo("IMPORT SUCCESS");
        assertThat(result.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    void importFile_invalidFileType_returns400() {
        File invalidFile = new File("invalidFileType");

        ResponseEntity<String> result = template.postForEntity(base.toString() + "/import", invalidFile, String.class);

        assertThat(result.getBody()).isEqualTo("INVALID PARSER");
        assertThat(result.getStatusCodeValue()).isEqualTo(400);
    }

    @Test
    void importFile_nullFileType_returns400() {
        File invalidFile = new File(null);

        ResponseEntity<String> result = template.postForEntity(base.toString() + "/import", invalidFile, String.class);

        assertThat(result.getBody()).isEqualTo("INVALID PARSER");
        assertThat(result.getStatusCodeValue()).isEqualTo(400);
    }

    @Test
    void importFile_nullFile_returns415() {
        ResponseEntity<String> result = template.postForEntity(base.toString() + "/import", null, String.class);

        assertThat(result.getStatusCodeValue()).isEqualTo(415);
    }
}
