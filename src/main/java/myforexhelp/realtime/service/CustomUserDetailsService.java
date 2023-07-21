package myforexhelp.realtime.service;

import myforexhelp.realtime.domain.Admin;
import myforexhelp.realtime.domain.CustomUserDetails;
import myforexhelp.realtime.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private AdminRepository adminRepository;

    public CustomUserDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

        Optional<Admin> optionalAdmin = adminRepository.findByUser(user);

        optionalAdmin
                .orElseThrow(() -> new UsernameNotFoundException("Wrong user or password"));
        return optionalAdmin
                .map(CustomUserDetails::new).get();
    }
}
