CREATE TABLE IF NOT EXISTS products (
                                        id                                  bigserial primary key,
                                        title                               varchar(255),
                                        price                               int,
                                        secret_key                          varchar(255));


INSERT INTO products (title, price, secret_key) VALUES
                                        ('Demon Souls', 80, 'asfdasdf'),
                                        ('Dark Souls', 80, 'asfdasdf'),
                                        ('Dark Souls2', 80, 'asfdasdf'),
                                        ('Dark Souls3', 80, 'asfdasdf'),
                                        ('Bloodborne', 80, 'asfdasdf'),
                                        ('Sekiro', 80, 'asfdasdf'),
                                        ('Elden Ring', 80, 'asfdasdf'),
                                        ('StarCraft', 80, 'asfdasdf'),
                                        ('World of Warcraft ', 80, 'asfdasdf'),
                                        ('World of Warcraft: Wrath of the Lich King', 80, 'asfdasdf'),
                                        ('StarCraft II', 80, 'asfdasdf'),
                                        ('StarCraft II Wings of Liberty', 80, 'asfdasdf'),
                                        ('StarCraft II: Heart of the Swarm', 80, 'asfdasdf'),
                                        ('StarCraft II: Legacy of the Void', 80, 'asfdasdf'),
                                        ('Dota', 80, 'asfdasdf'),
                                        ('Dota 2', 80, 'asfdasdf'),
                                        ('World of Warcraft: Burning Crusade', 80, 'asfdasdf'),
                                        ('World of Warcraft: Cataclysm', 80, 'asfdasdf'),
                                        ('World of Warcraft: Mists of Pandaria', 80, 'asfdasdf'),
                                        ('World of Warcraft: Warlords of Draenor', 80, 'asfdasdf');
