package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period = 10_000_000_000_000L;
    protected StringBuilder processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    static List<String> stringArrayList = new LinkedList<>();

    public LocalProcessor() {
    }

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, List<String> stringArrayList) {
        this.processorName = new StringBuilder(processorName);
        this.period = period;
        this.processorVersion = new StringBuilder(processorVersion);
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationscanner;
        LocalProcessor.stringArrayList = stringArrayList;
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {

        if (stringList.size() != 0) {
            stringArrayList = new LinkedList<>(stringList);
            stringArrayList.forEach(System.out::println);

        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder sb = new StringBuilder(processorName);
        if (sb != null) {
            for (String str : stringList) {
                sb.append(str);
            }
        }

        return sb.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                if (informationScanner != null) {
                    processorVersion.append(informationScanner.nextLine());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            informationScanner.close();
        }

    }
}
