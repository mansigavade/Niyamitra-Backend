package Niyamitra.niyamitra.service;

import Niyamitra.niyamitra.dto.GenerateReportDTO;

import java.util.List;

public interface GenerateReportService {

    GenerateReportDTO createReport(GenerateReportDTO dto);

    List<GenerateReportDTO> getAllReports();

    GenerateReportDTO getReportById(Long id);

    GenerateReportDTO updateReport(Long id, GenerateReportDTO dto);

    void deleteReport(Long id);
}
