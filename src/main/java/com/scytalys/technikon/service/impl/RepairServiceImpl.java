package com.scytalys.technikon.service.impl;

import com.scytalys.technikon.domain.Repair;
import com.scytalys.technikon.repository.RepairRepository;
import com.scytalys.technikon.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {
    private final RepairRepository repairRepository;


    @Override
    public void update(final Repair repair, final Long repairId) {
        Repair existingRepair = repairRepository.findById(repairId).orElseThrow(
                () -> new RuntimeException("Repair with id -> %s not found".formatted(repairId))
        );
        existingRepair.setRepairType(repair.getRepairType());
        existingRepair.setRepairStatus(repair.getRepairStatus());
        existingRepair.setDescription(repair.getDescription());
        existingRepair.setRepairDate(repair.getRepairDate());
        existingRepair.setCost(repair.getCost());

        repairRepository.save(existingRepair);
    }

    @Override
    public Repair create(final Repair repair) {
        return repairRepository.save(repair);
    }

    @Override
    public List<Repair> findRepairByDate(final Date repairDate) {
        return repairRepository.findByRepairDate(repairDate).orElse(null);
    }

    @Override
    public void delete(final Repair repair) {
        final Repair existingRepair = repairRepository.getReferenceById(repair.getId());
        repairRepository.delete(existingRepair);
    }

    @Override
    public void delete(final Long repairId) {
        final Repair existingRepair = repairRepository.getReferenceById(repairId);
        repairRepository.delete(existingRepair);
    }

}
