package lt.viko.eif.imazolevska.jaxws_client.runner;

import lt.viko.eif.imazolevska.jaxws.transform.XslTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Unit tests for {@link TransformationRunner}.
 */
@ExtendWith(MockitoExtension.class)
class TransformationRunnerTest {

    @Mock
    XslTransformer htmlTransformer;

    @Mock
    XslTransformer pdfTransformer;


    @Test
    void runCallsBothTransformers() throws Exception {
        TransformationRunner runner = new TransformationRunner(pdfTransformer, htmlTransformer);

        runner.run();

        verify(htmlTransformer).transform(anyString(), anyString(), anyString());
        verify(pdfTransformer).transform(anyString(), anyString(), anyString());

    }
}